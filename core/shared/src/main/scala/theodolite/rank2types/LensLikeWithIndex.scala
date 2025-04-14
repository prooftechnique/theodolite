package theodolite.rank2types

import cats.Applicative

private[theodolite] trait LensLikeWithIndex[I, S, T, A, B] {
  def apply[F[_]](f: ((A, I)) => F[B])(implicit ev: Applicative[F]): S => F[T]
}
