package theodolite.std

import scala.Function.const

import theodolite.Lens

trait UnitOptics {
  final def unit[A]: Lens[A, Unit] = Lens[A, Unit](const(()))(const)
}
