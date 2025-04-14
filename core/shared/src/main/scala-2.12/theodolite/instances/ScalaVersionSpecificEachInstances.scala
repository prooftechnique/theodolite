package theodolite.instances

import theodolite.Traversal
import theodolite.typeclass.Each

private[instances] trait ScalaVersionSpecificEachInstances {
  implicit final def eachStream[A]: Each[Stream[A], A] = new Each[Stream[A], A] {
    override def each: Traversal[Stream[A], A] = Traversal.fromTraverse[Stream, A]
  }
}
