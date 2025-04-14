package theodolite.examples

import cats.syntax.option._

import theodolite.instances.cons._
import theodolite.instances.field1._
import theodolite.instances.field2._
import theodolite.instances.prefixed._
import theodolite.instances.suffixed._
import theodolite.specs.TheodoliteSuite
import theodolite.std.tuple._
import theodolite.{AffineTraversal, Traversal}

class AffineTraversalExamples extends TheodoliteSuite {
  test("preview the head of a list within a tuple") {
    val composed = _2[Int, List[String]] andThen headOption[List[String], String]
    val result = composed.preview((9, List("head", "?", "?")))

    assertResult("head".some)(result)
  }

  test("transform each head of a nested list to upper case") {
    val composed = Traversal.fromTraverse[List, List[String]] andThen headOption[List[String], String]
    val result = composed.over(_.toUpperCase)(List(List("a", "b", "c"), List("b", "c", "d"), List.empty))

    assertResult(List(List("A", "b", "c"), List("B", "c", "d"), List.empty))(result)
  }

  test("remove the suffix or prefix of a string") {
    val suffixedComposed: AffineTraversal[(String, Int), String] =
      _1[String, Int] andThen suffixed[String, String]("fix")
    val prefixedComposed: AffineTraversal[(String, Int), String] =
      _1[String, Int] andThen prefixed[String, String]("pre")

    assertResult("suf".some)(suffixedComposed.preview(("suffix", 9)))
    assertResult("pre".some)(suffixedComposed.preview(("prefix", 9)))
    assertResult("fix".some)(prefixedComposed.preview(("prefix", 9)))
    assertResult(None)(prefixedComposed.preview(("suffix", 9)))
  }
}
