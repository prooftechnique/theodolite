package theodolite.specs

import theodolite.instances.foldableWithIndex._
import theodolite.law.discipline.FoldableWithIndexTests

class FoldableWithIndexSpec extends FoldableWithIndexSpec0 {
  checkAll("FoldableWithIndex[Stream, Int]", FoldableWithIndexTests[Stream, Int].foldableWithIndex[Int, Int, Int])
}
