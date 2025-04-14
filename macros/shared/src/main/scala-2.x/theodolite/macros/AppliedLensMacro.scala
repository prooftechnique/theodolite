package theodolite.macros

import scala.reflect.macros.blackbox

import theodolite.AppliedLens

private[macros] class AppliedLensMacro(val c: blackbox.Context) {
  import c.universe._

  def genAppliedLens_impl[S: c.WeakTypeTag, A: c.WeakTypeTag](field: c.Expr[S => A]): c.Expr[AppliedLens[S, A]] = {
    val weakTypeOfA = c.weakTypeOf[S]
    val appliedType =
      c.prefix.tree match {
        case Apply(_: TypeApply, List(appliedTree)) => appliedTree
        case t =>
          c.abort(c.enclosingPosition, s"Could not resolve applied type ${show(t)}")
      }
    val tree = q"_root_.theodolite.applied.AppliedLens($appliedType, _root_.theodolite.macros.GLens[$weakTypeOfA]($field))"
    c.Expr[AppliedLens[S, A]](tree)
  }
}
