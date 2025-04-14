package theodolite.specs

import scala.collection.immutable.ArraySeq

import theodolite.instances.prefixed._
import theodolite.law.discipline.PrefixedTests

class PrefixedSpec extends PrefixedSpec0 {
  checkAll("PrefixedTests[LazyList[Int], LazyList[Int]] prefix", PrefixedTests[LazyList[Int], LazyList[Int]].prefixed)
  checkAll("PrefixedTests[ArraySeq[Int], ArraySeq[Int]] prefix", PrefixedTests[ArraySeq[Int], ArraySeq[Int]].prefixed)
}
