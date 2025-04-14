package theodolite.specs

import theodolite.APrism
import theodolite.law.discipline.APrismTests
import theodolite.macros.GAPrism

class GAPrismSpec extends TheodoliteSuite {
  val genAPrism: APrism[Json, JString] = GAPrism[Json, JString]

  checkAll("GAPrism[Json, JString]", APrismTests(genAPrism).aPrism)
}
