package theodolite.specs

import theodolite.instances.empty._
import theodolite.law.discipline.EmptyTests

class EmptySpec extends EmptySpec0 {
  checkAll("Empty[Stream[Int]]", EmptyTests[Stream[Int]].empty)
}
