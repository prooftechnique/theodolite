package theodolite.applied.internal

import theodolite.internal.Review0

private[theodolite] trait AppliedReview0[T, B] extends Serializable {
  val optic: Review0[T, B]

  def review(b: B): T = optic.review(b)
}
