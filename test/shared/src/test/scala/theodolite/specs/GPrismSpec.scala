package theodolite.specs

import theodolite.Prism
import theodolite.law.discipline.PrismTests
import theodolite.macros.GPrism

class GPrismSpec extends TheodoliteSuite {
  val genPrism: Prism[Json, JString] = GPrism[Json, JString]

  checkAll("GPrism[Json, JString]", PrismTests(genPrism).prism)
}
