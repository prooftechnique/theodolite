package theodolite.macros

import scala.quoted.{Expr, Quotes, Type, quotes}

import theodolite.AppliedLens

object AppliedLensImpl {
  def apply[S: Type, A: Type](s: Expr[S], field: Expr[S => A])(using Quotes): Expr[AppliedLens[S, A]] =
    new AppliedLensMacro().genAppliedLens_impl[S, A](s, field)
}
