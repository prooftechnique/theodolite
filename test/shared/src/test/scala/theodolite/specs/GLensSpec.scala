package theodolite.specs

import theodolite.Lens
import theodolite.law.discipline.LensTests
import theodolite.macros.GLens

class GLensSpec extends TheodoliteSuite {
  val firstLevelGLens: Lens[Person, String] = GLens[Person](_.name)
  val leafLevelGLens: Lens[Person, Int] = GLens[Person](_.address.street.number)

  checkAll("GLens[Person, String] top level gen", LensTests(firstLevelGLens).lens)
  checkAll("GLens[Person, Int] leaf level gen", LensTests(leafLevelGLens).lens)
}
