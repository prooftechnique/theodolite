![Theodolite Logo](./theodolite.png)

[![CI](https://github.com/prooftechnique/Theodolite/actions/workflows/ci.yml/badge.svg)](https://github.com/prooftechnique/Theodolite/actions/workflows/ci.yml)
[![Maven Central](https://img.shields.io/maven-central/v/ch.proofte/theodolite-core_2.13.svg?color=32c954)](https://maven-badges.herokuapp.com/maven-central/ch.proofte/theodolite-core_2.13)
[![Scala Steward badge](https://img.shields.io/badge/Scala_Steward-helping-blue.svg?style=flat&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAQCAMAAAARSr4IAAAAVFBMVEUAAACHjojlOy5NWlrKzcYRKjGFjIbp293YycuLa3pYY2LSqql4f3pCUFTgSjNodYRmcXUsPD/NTTbjRS+2jomhgnzNc223cGvZS0HaSD0XLjbaSjElhIr+AAAAAXRSTlMAQObYZgAAAHlJREFUCNdNyosOwyAIhWHAQS1Vt7a77/3fcxxdmv0xwmckutAR1nkm4ggbyEcg/wWmlGLDAA3oL50xi6fk5ffZ3E2E3QfZDCcCN2YtbEWZt+Drc6u6rlqv7Uk0LdKqqr5rk2UCRXOk0vmQKGfc94nOJyQjouF9H/wCc9gECEYfONoAAAAASUVORK5CYII=)](https://scala-steward.org)

### Overview

Theodolite is a Profunctor Optics and Lenses library for [Scala programming language](https://scala-lang.org).</br>
It uses a Profunctor encoding for its internal representation of optics, you can learn about profunctors in the [profunctor](https://proofte.ch/Theodolite/docs/profunctors/profunctor) guide.</br>
Theodolite is available for Scala 2.12, Scala 2.13, Scala 3.0, and [Scala.js](http://www.scala-js.org/),
and is built on top of [Cats](https://typelevel.org/cats/), and [Spire](https://typelevel.org/spire/).


### Getting Started

Add to your `build.sbt`
```scala
libraryDependencies ++= Seq(
  "ch.proofte" %% "theodolite-core" % "0.5.2",
  "ch.proofte" %% "theodolite-profunctor" % "0.5.2",
  "ch.proofte" %% "theodolite-macros" % "0.5.2"
)
```

Quick links:

* [Website][website]
* [Guide][guide]

[website]: https://proofte.ch/Theodolite/
[guide]: https://proofte.ch/Theodolite/docs/overview
[theodolite-api]: https://proofte.ch/Theodolite/api/theodolite/

### Documentation

* There is a Scaladoc API documentation for the [library][theodolite-api], which includes optics ([Lens](https://proofte.ch/Theodolite/api/theodolite/Lens_), [Traversal](https://proofte.ch/Theodolite/api/theodolite/Traversal_) [Fold](https://proofte.ch/Theodolite/api/theodolite/Fold_), and more)
  [Profunctors](https://proofte.ch/Theodolite/api/theodolite/profunctor/), and [Data types](https://proofte.ch/Theodolite/api/theodolite/internal/) </br>
