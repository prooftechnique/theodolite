package theodolite.internal

/** @tparam S
  *   the source of a [[theodolite.Prism_]]
  * @tparam T
  *   the modified source of a [[theodolite.Prism_]]
  * @tparam A
  *   the focus of a [[theodolite.Prism_]]
  */
private[theodolite] trait PrismFunctions[S, T, A] {
  def viewOrModify(s: S): Either[T, A]
}
