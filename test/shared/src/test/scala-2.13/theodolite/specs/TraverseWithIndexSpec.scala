package theodolite.specs

import scala.collection.compat.immutable.ArraySeq

import cats.Id

import theodolite.instances.traverseWithIndex._
import theodolite.law.discipline.TraverseWithIndexTests

class TraverseWithIndexSpec extends TraverseWithIndexSpec0 {
  checkAll("TraverseWithIndex[LazyList, Int]", TraverseWithIndexTests[LazyList, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[ArraySeq, Int]", TraverseWithIndexTests[ArraySeq, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
}
