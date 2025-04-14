package theodolite.rank2types

import theodolite.profunctor.Closed

private[theodolite] trait Rank2TypeGrateLike[S, T, A, B] {
  def apply[P[_, _]](pab: P[A, B])(implicit ev: Closed[P]): P[S, T]
}
