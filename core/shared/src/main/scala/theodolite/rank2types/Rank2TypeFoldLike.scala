package theodolite.rank2types

import cats.Monoid

import theodolite.internal.Forget

private[theodolite] trait Rank2TypeFoldLike[S, T, A, B] {
  def apply[R: Monoid](forget: Forget[R, A, B]): Forget[R, S, T]
}
