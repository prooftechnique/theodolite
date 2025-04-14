package theodolite.specs

import theodolite.instances.index._
import theodolite.law.discipline.IndexTests

class IndexSpec extends IndexSpec0 {
  checkAll("Index[Stream[Int]]", IndexTests[Stream[Int], Int, Int].index)
}
