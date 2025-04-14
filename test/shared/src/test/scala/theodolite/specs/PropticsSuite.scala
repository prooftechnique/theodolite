package theodolite.specs

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import org.scalatest.prop.Configuration
import org.typelevel.discipline.scalatest.FunSuiteDiscipline

trait TheodoliteSuite extends AnyFunSuite with Configuration with FunSuiteDiscipline with Matchers
