package theodolite.macros

import scala.quoted.{Expr, Quotes, Type, quotes}

import theodolite.APrism

object GenAPrismImpl {
  def apply[S: Type, A: Type](using Quotes): Expr[APrism[S, A]] =
    new GenPrismMacro(quotes).genAPrism_impl[S, A]
}
