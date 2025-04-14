package theodolite.specs

import scala.collection.compat.immutable.ArraySeq

import theodolite.instances.reverse._
import theodolite.law.discipline.ReverseTests

class ReverseSpec extends ReverseSpec0 {
  checkAll("ReverseTests[LazyList[Int], LazyList[Int]] reverse", ReverseTests[LazyList[Int], LazyList[Int]].reverse)
  checkAll("ReverseTests[ArraySeq[Int], ArraySeq[Int]] reverse", ReverseTests[ArraySeq[Int], ArraySeq[Int]].reverse)
}
