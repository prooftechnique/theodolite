package theodolite.specs

import scala.collection.immutable.Stream

import theodolite.instances.each._
import theodolite.law.discipline.EachTests

class EachSpec extends EachSpec0 {
  checkAll("Each[Stream[Int], Int] Each", EachTests[Stream[Int], Int].each)
}
