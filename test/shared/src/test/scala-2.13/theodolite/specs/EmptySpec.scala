package theodolite.specs

import scala.collection.compat.immutable.ArraySeq

import theodolite.instances.empty._
import theodolite.law.discipline.EmptyTests

class EmptySpec extends EmptySpec0 {
  checkAll("Empty[LazyList[Int]]", EmptyTests[LazyList[Int]].empty)
  checkAll("Empty[ArraySeq[Int]]", EmptyTests[ArraySeq[Int]].empty)
}
