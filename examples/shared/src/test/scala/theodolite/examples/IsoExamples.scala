package theodolite.examples

import cats.instances.either._
import cats.syntax.either._

import theodolite.Iso
import theodolite.Iso._
import theodolite.instances.field2._
import theodolite.instances.reverse._
import theodolite.specs.TheodoliteSuite
import theodolite.std.either._
import theodolite.std.list._
import theodolite.std.string._
import theodolite.std.tuple._
import theodolite.syntax.iso._

class IsoExamples extends TheodoliteSuite {
  test("swap Tuple") {
    val tuple = ("Hello", 9)

    assertResult(tuple.swap)(swapTuple[String, Int].view(tuple))
  }

  test("swap Either") {
    val either: Either[String, Int] = "Hello".asLeft[Int]

    assertResult(either.swap)(swapEither[String, Int].view(either))
  }

  test("swap Either twice") {
    val either: Either[String, Int] = "Hello".asLeft[Int]
    val swapTwice: Iso[Either[String, Int], Either[String, Int]] =
      swapEither andThen swapEither

    assertResult(either)(swapTwice.view(either))
  }

  test("replace the case of all characters using involuted") {
    val composed =
      _2[Int, String] andThen
        stringToChars andThen
        involuted[List[Char]](_.map(c => if (c.isUpper) c.toLower else c.toUpper)) andThen
        charsToString

    val input = (9, "Hi")
    assertResult((9, "camelCase"))(composed.set("CAMELcASE")(input))
  }

  test("reverse the string of an either using map") {
    val composed =
      stringToChars andThen
        reverse[List[Char], List[Char]] andThen
        charsToString

    val input = Right("desrever")
    assertResult(Right("reversed"))(composed.map[Either[Int, *]] view input)
    assertResult(Left(9))(composed.map[Either[Int, *]] view Left(9))
  }

  test("reverse both sides of an either using bimap") {
    val composed =
      stringToChars andThen
        reverse[List[Char], List[Char]] andThen
        charsToString

    assertResult(Right("reversed"))(composed.bimap[Either] view Right("desrever"))
    assertResult(Left("reversed"))(composed.bimap[Either] view Left("desrever"))
  }

  test("using contramap to create a string from boolean") {
    val negate = Iso.involuted[Boolean](!_).contramap[* => String]

    assertResult("false")(negate.view(_.toString)(true))
  }
}
