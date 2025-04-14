package theodolite.specs

import theodolite.instances.functorWithIndex._
import theodolite.law.discipline.FunctorWithIndexTests

class FunctorWithIndexSpec extends FunctorWithIndexSpec0 {
  checkAll("FunctorWithIndex[Stream, Int]", FunctorWithIndexTests[Stream, Int].functorWithIndex[Int, Int, Int])
}
