package theodolite.specs

import scala.collection.compat.immutable.ArraySeq

import theodolite.instances.cons._
import theodolite.law.discipline.ConsTests

class ConsSpec extends ConsSpec0 {
  checkAll("Cons[LazyList[Int]]", ConsTests[LazyList[Int], Int].cons)
  checkAll("Cons[ArraySeq[Int]]", ConsTests[ArraySeq[Int], Int].cons)
}
