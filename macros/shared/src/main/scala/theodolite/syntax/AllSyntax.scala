package theodolite.syntax

import theodolite.syntax.applied.AppliedSyntax
import theodolite.syntax.macros.MacroSyntax

trait AllSyntax extends CoreSyntax with AppliedSyntax with MacroSyntax

object all extends AllSyntax
