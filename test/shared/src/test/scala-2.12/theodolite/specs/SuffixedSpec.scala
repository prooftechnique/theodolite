package theodolite.specs

import theodolite.instances.suffixed._
import theodolite.law.discipline.SuffixedTests

class SuffixedSpec extends SuffixedSpec0 {
  checkAll("SuffixedTests[Stream[Int], Stream[Int]] suffix", SuffixedTests[Stream[Int], Stream[Int]].suffixed)
}
