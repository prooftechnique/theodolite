import BuildHelper._
import Dependencies._
import MimaSettings.mimaSettings
import sbt.Keys._

Global / onChangedBuildSource := ReloadOnSourceChanges

inThisBuild(
  List(
    organization := "ch.proofte",
    homepage := Some(url("https://github.com/prooftechnique/theodolite")),
    licenses := Seq("MIT" -> url("http://opensource.org/licenses/MIT")),
    developers := List(
      Developer(
        "jhenahan",
        "Jack Henahan",
        "root@proofte.ch",
        url("https://github.com/jhenahan")
      )
    ),
    latestVersion := {
      val snapshot = (ThisBuild / isSnapshot).value
      val stable = (ThisBuild / isVersionStable).value

      if (!snapshot && stable) {
        (ThisBuild / version).value
      } else {
        (ThisBuild / previousStableVersion).value.getOrElse("0.0.0")
      }
    }
  ))

addCommandAlias("build", "prepare; testJVM")
addCommandAlias("prepare", "fix; fmt")
addCommandAlias("check", "fmtCheck; fixCheck")
addCommandAlias("fix", "all compile:scalafix test:scalafix")
addCommandAlias("fmt", "all theodolite/scalafmtSbt theodolite/scalafmtAll")
addCommandAlias("fixCheck", "compile:scalafix --check ; test:scalafix --check")
addCommandAlias("fmtCheck", "all theodolite/scalafmtSbtCheck theodolite/scalafmtCheckAll")
addCommandAlias("compileJVM", "theodoliteJVM/test:compile")
addCommandAlias("compileJS", "theodoliteJS/test:compile")
addCommandAlias("testJVM", "theodoliteJVM/test;")
addCommandAlias("testJS", "theodoliteJS/test;")
addCommandAlias(
  "mimaCheck",
  "all coreJVM/mimaReportBinaryIssues profunctorJVM/mimaReportBinaryIssues"
)
lazy val theodolite = project
  .in(file("."))
  .settings(moduleName := "theodolite")
  .settings(noPublishSettings)
  .settings(stdSettings)
  .settings(welcomeMessage)
  .aggregate(theodoliteJVM, theodoliteJS)
  .dependsOn(theodoliteJVM, theodoliteJS)
  .enablePlugins(ScalaJSPlugin)

lazy val theodoliteJVM = project
  .in(file(".theodoliteJVM"))
  .settings(noPublishSettings)
  .aggregate(core.jvm, profunctor.jvm, macros.jvm, law.jvm, test.jvm, examples.jvm)
  .dependsOn(core.jvm, profunctor.jvm, macros.jvm, law.jvm, test.jvm)

lazy val theodoliteJS = project
  .in(file(".theodoliteJS"))
  .settings(noPublishSettings)
  .aggregate(core.js, profunctor.js, macros.js, law.js, test.js, examples.js)
  .dependsOn(core.js, profunctor.js, macros.js, law.js, test.js)

lazy val core = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .dependsOn(profunctor)
  .settings(stdProjectSettings("core"))
  .settings(crossProjectSettings)
  .settings(additionalDependencies)

lazy val coreJS = core.js
lazy val coreJVM = core.jvm.settings(mimaSettings(false))

lazy val profunctor = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .settings(stdProjectSettings("profunctor"))
  .settings(crossProjectSettings)
  .settings(libraryDependencies ++= Seq(cats.value))

lazy val profunctorJS = profunctor.js
lazy val profunctorJVM = profunctor.jvm.settings(mimaSettings(false))

lazy val macros = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .in(file("macros"))
  .dependsOn(core)
  .settings(crossProjectSettings)
  .settings(stdProjectSettings("macros"))
  .settings(macroDefinitionSettings)

lazy val macrosJVM = macros.jvm
lazy val macrosJS = macros.js

lazy val examples = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .dependsOn(core, profunctor, macros, test % "test->test")
  .settings(noPublishSettings)
  .settings(stdProjectSettings("examples"))
  .settings(crossProjectSettings)
  .settings(libraryDependencies ++= {
    val dependencies = Seq(cats.value, catsLaws.value, discipline.value, disciplineScalatest.value)
    if (isScala3(scalaVersion.value)) dependencies
    else scalaCompiler.value +: dependencies
  })
  .settings(additionalDependencies)

lazy val examplesJVM = examples.jvm
lazy val examplesJS = examples.js

lazy val law = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .dependsOn(core, profunctor)
  .settings(stdProjectSettings("law"))
  .settings(crossProjectSettings)
  .settings(libraryDependencies ++= Seq(cats.value, catsLaws.value, discipline.value))
  .settings(additionalDependencies)

lazy val test = crossProject(JVMPlatform, JSPlatform)
  .crossType(CrossType.Pure)
  .dependsOn(core, profunctor, macros, law)
  .settings(stdProjectSettings("test"))
  .settings(crossProjectSettings)
  .settings(libraryDependencies ++= Seq(cats.value, catsLaws.value, discipline.value, disciplineScalatest.value))
  .settings(additionalDependencies)

lazy val docs = project
  .in(file("docs"))
  .dependsOn(core.jvm, profunctor.jvm, law.jvm)
  .settings(moduleName := "theodolite-docs")
  .settings(noPublishSettings)
  .settings(stdSettings)
  .settings(mdocSettings(core.jvm, profunctor.jvm, law.jvm))
  .settings(buildInfoSettings(core.jvm))
  .settings(libraryDependencies ++= Seq(cats.value))
  .settings(additionalDependencies)
  .enablePlugins(BuildInfoPlugin, DocusaurusPlugin, MdocPlugin, ScalaUnidocPlugin)
