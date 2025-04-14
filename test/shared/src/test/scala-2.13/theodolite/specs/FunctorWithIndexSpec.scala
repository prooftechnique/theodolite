package theodolite.specs

import scala.collection.compat.immutable.ArraySeq

import theodolite.instances.functorWithIndex._
import theodolite.law.discipline.FunctorWithIndexTests

class FunctorWithIndexSpec extends FunctorWithIndexSpec0 {
  checkAll("FunctorWithIndex[LazyList, Int]", FunctorWithIndexTests[LazyList, Int].functorWithIndex[Int, Int, Int])
  checkAll("FunctorWithIndex[ArraySeq, Int]", FunctorWithIndexTests[ArraySeq, Int].functorWithIndex[Int, Int, Int])
}
