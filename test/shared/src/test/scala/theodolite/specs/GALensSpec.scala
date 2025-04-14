package theodolite.specs

import theodolite.ALens
import theodolite.law.discipline.ALensTests
import theodolite.macros.GALens

class GALensSpec extends TheodoliteSuite {
  val firstLevelGALens: ALens[Person, String] = GALens[Person](_.name)
  val leafLevelGALens: ALens[Person, Int] = GALens[Person](_.address.street.number)

  checkAll("GALens[Person, String] top level gen", ALensTests(firstLevelGALens).aLens)
  checkAll("GALens[Person, Int] leaf level gen", ALensTests(leafLevelGALens).aLens)
}
