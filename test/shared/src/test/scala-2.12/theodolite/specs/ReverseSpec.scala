package theodolite.specs

import theodolite.instances.reverse._
import theodolite.law.discipline.ReverseTests

class ReverseSpec extends ReverseSpec0 {
  checkAll("ReverseTests[Stream[Int], Stream[Int]] reverse", ReverseTests[Stream[Int], Stream[Int]].reverse)
}
