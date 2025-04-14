package theodolite.rank2types

import theodolite.profunctor.Wander

private[theodolite] trait Rank2TypeTraversalLike[S, T, A, B] {
  def apply[P[_, _]](pab: P[A, B])(implicit ev: Wander[P]): P[S, T]
}
