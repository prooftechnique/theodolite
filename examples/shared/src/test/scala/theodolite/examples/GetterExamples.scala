package theodolite.examples

import theodolite.Getter
import theodolite.specs.TheodoliteSuite

class GetterExamples extends TheodoliteSuite {
  test("focus into nested data") {
    val composed =
      Getter[Person](_.address) andThen
        Getter[Address](_.street)

    assertResult(Street("Negra Arroyo Lane", 308))(composed.view(mrWhite))
  }

  test("using to in order to focus into nested data") {
    val composed =
      Getter[Person](_.address) focus (_.street)

    assertResult(Street("Negra Arroyo Lane", 308))(composed.view(mrWhite))
  }
}
