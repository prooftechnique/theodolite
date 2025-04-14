package theodolite.specs

import theodolite.instances.prefixed._
import theodolite.law.discipline.PrefixedTests

class PrefixedSpec extends PrefixedSpec0 {
  checkAll("PrefixedTests[Stream[Int], Stream[Int]] prefix", PrefixedTests[Stream[Int], Stream[Int]].prefixed)
}
