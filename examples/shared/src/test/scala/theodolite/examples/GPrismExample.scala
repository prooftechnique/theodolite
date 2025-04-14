package theodolite.examples

import cats.syntax.option._

import theodolite.macros.GPrism
import theodolite.specs.TheodoliteSuite

class GPrismExample extends TheodoliteSuite {
  test("using GPrism to generate prisms for sum types") {
    val prism = GPrism[Request, GET]

    assertResult(GET(List("path")).some)(prism.preview(GET(List("path"))))
    assertResult(None)(prism.preview(POST(List("path"), "body")))
  }
}
