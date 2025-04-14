package theodolite.rank2types

import cats.arrow.Strong

private[theodolite] trait Rank2TypeLensLike[S, T, A, B] {
  def apply[P[_, _]](pab: P[A, B])(implicit ev: Strong[P]): P[S, T]
}
