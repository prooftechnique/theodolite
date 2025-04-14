{...}: {
  perSystem = {
    config,
    pkgs,
    lib,
    ...
  }: let
    inherit (lib) mkOption mkEnableOption mkIf types;
    cfg = config.languages;
  in {
    options = {
      languages = {
        java = {
          enable = mkEnableOption "Tools for Java development" // {default = config.languages.scala.enable;};
          package = mkOption {
            type = with types; uniq package;
            description = "Primary JDK version.";
            default = pkgs.jdk;
            example = "pkgs.jdk11";
          };
        };
        scala = {
          enable = mkEnableOption "Tools for Scala development" // {default = true;};
          package = mkOption {
            type = with types; uniq package;
            description = "Primary Scala version.";
            default = pkgs.scala_2_13;
            example = "pkgs.scala-next";
          };
        };
        enable = mkEnableOption "Tools for library development" // {default = true;};
      };
    };

    config = mkIf cfg.enable {
      packages = let
        lib = builtins // pkgs.lib;
        jre = cfg.java.package;
        ammonite_versioned =
          if lib.versionOlder cfg.scala.package.version "2.13"
          then pkgs.ammonite_2_12
          else if lib.versionOlder cfg.scala.package.version "3"
          then pkgs.ammonite_2_13
          else pkgs.ammonite;
        ammonite = ammonite_versioned.override {inherit jre;};
      in {
        inherit jre ammonite;
        scala = cfg.scala.package.override {inherit jre;};
        metals = pkgs.metals.override {inherit jre;};
        sbt = pkgs.sbt.override {inherit jre;};
        coursier = pkgs.coursier.override {inherit jre;};
        bleep = pkgs.bleep;
      };
    };
  };
}
