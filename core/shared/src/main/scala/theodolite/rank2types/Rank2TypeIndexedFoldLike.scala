package theodolite.rank2types

import cats.Monoid

import theodolite.internal.{Forget, Indexed}

private[theodolite] trait Rank2TypeIndexedFoldLike[I, S, T, A, B] {
  def apply[R](indexed: Indexed[Forget[R, *, *], I, A, B])(implicit ev: Monoid[R]): Forget[R, S, T]
}
