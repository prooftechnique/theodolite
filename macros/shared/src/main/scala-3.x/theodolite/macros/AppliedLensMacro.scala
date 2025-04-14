package theodolite.macros

import scala.quoted.{Expr, Quotes, Type, quotes}

import theodolite.applied.AppliedLens
import theodolite.{AppliedLens, Lens}

private[macros] class AppliedLensMacro(using Quotes) {
  import quotes.reflect._

  def genAppliedLens_impl[S: Type, A: Type](s: Expr[S], field: Expr[S => A]): Expr[AppliedLens[S, A]] = {
    val generatedLens = GLensImpl(field)
    '{ AppliedLens.apply[S, A]($s, $generatedLens) }
  }
}
