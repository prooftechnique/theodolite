package theodolite.instances

import theodolite.internal.{Bazaar, CorepresentableInstances, Sellable, SellableInstances}
import theodolite.profunctor.Corepresentable.Aux

trait PartsOf extends SellableInstances with CorepresentableInstances {
  implicit def partsOfSellable[A](implicit ev: Aux[* => *, Bazaar[* => *, List[A], List[A], Unit, *]]): Sellable[* => *, Bazaar[* => *, *, *, Unit, *]] =
    sellableBazaar[* => *, Bazaar[* => *, List[A], List[A], Unit, *]]
}
