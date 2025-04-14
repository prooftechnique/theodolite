package theodolite.instances

import theodolite.Prism
import theodolite.typeclass.Empty

private[instances] trait ScalaVersionSpecificEmptyInstances {
  implicit final def emptyLazyStream[A]: Empty[Stream[A]] = new Empty[Stream[A]] {
    override def empty: Prism[Stream[A], Unit] = Prism.nearly(Stream.empty[A])(_.isEmpty)
  }
}
