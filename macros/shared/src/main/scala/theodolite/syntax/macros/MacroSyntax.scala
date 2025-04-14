package theodolite.syntax.macros

import theodolite.macros.AppliedLensSyntaxCompat

trait MacroSyntax extends AppliedLensSyntaxCompat

object all extends MacroSyntax
object lens extends AppliedLensSyntaxCompat
