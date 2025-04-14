package theodolite.specs

import theodolite.instances.cons._
import theodolite.law.discipline.ConsTests

class ConsSpec extends ConsSpec0 {
  checkAll("Cons[Stream[Int]]", ConsTests[Stream[Int], Int].cons)
}
