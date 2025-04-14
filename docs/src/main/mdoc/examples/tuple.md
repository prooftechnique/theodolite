---
id: tuple
title: Tuple
---

#### swap

Swap the elements of a Tuple

```scala
import theodolite.instances.all._
import theodolite.syntax.all._

final case class Boo(pair: (Int, String))

Boo((1, "First"))
  .lens(_.pair)
  .swap
  .view

// val res0: (String, Int) = (First,1)
```



