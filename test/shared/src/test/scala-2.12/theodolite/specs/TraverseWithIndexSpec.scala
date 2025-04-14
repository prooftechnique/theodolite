package theodolite.specs

import cats.Id

import theodolite.instances.traverseWithIndex._
import theodolite.law.discipline.TraverseWithIndexTests

class TraverseWithIndexSpec extends TraverseWithIndexSpec0 {
  checkAll("TraverseWithIndex[Stream, Int]", TraverseWithIndexTests[Stream, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
}
