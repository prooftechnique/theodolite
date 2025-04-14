package theodolite.rank2types

import theodolite.profunctor.Choice

private[theodolite] trait Rank2TypePrismLike[S, T, A, B] {
  def apply[P[_, _]](pab: P[A, B])(implicit ev: Choice[P]): P[S, T]
}
