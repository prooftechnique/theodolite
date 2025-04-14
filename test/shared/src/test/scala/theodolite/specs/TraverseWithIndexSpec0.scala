package theodolite.specs

import cats.Id
import cats.data.{Chain, NonEmptyChain, NonEmptyList, NonEmptyMap, NonEmptyVector, OneAnd}

import theodolite.instances.traverseWithIndex._
import theodolite.law.discipline.TraverseWithIndexTests

private[specs] trait TraverseWithIndexSpec0 extends TheodoliteSuite {
  checkAll("TraverseWithIndex[Option, Unit]", TraverseWithIndexTests[Option, Unit].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[Vector, Int]", TraverseWithIndexTests[Vector, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[List, Int]", TraverseWithIndexTests[List, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[Chain, Int]", TraverseWithIndexTests[Chain, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[NonEmptyVector, Int]", TraverseWithIndexTests[NonEmptyVector, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[NonEmptyList, Int]", TraverseWithIndexTests[NonEmptyList, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[NonEmptyChain, Int]", TraverseWithIndexTests[NonEmptyChain, Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[OneAnd, Int]", TraverseWithIndexTests[OneAnd[List, *], Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
  checkAll("TraverseWithIndex[NonEmptyMap[Int, *], Int]", TraverseWithIndexTests[NonEmptyMap[Int, *], Int].traverseWithIndex[Int, Int, Int, Int, Id, Id])
}
