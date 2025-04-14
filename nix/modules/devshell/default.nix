{...}: {
  imports = [
    ../formatter
    ../compiler
  ];

  perSystem = {
    config,
    pkgs,
    self',
    ...
  }: let
    inherit (config.languages) java;
  in {
    devShells.default = pkgs.mkShell {
      name = "theodolite";
      packages =
        [
          config.treefmt.build.wrapper
          pkgs.emacs-lsp-booster
        ]
        ++ builtins.attrValues self'.packages;
      env = {
        JAVA_HOME = java.package.home;
      };
    };
  };
}
