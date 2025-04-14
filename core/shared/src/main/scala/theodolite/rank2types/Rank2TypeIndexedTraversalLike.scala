package theodolite.rank2types

import theodolite.internal.Indexed
import theodolite.profunctor.Wander

private[theodolite] trait Rank2TypeIndexedTraversalLike[I, S, T, A, B] {
  def apply[P[_, _]](indexed: Indexed[P, I, A, B])(implicit ev: Wander[P]): P[S, T]
}
