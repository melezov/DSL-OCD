package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup
package LocationTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableLocation_3
    extends OcdSpec {

    /* Testing the property field public visibility via reflection (no instantiation) */
    def `Test property field visibility`() =
      lock(
        typeOf[NullableLocation_3]
          .member("nullableLocation": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[java.awt.geom.Point2D]]
      , typeOf[NullableLocation_3]
          .member("nullableLocation": TermName)
          .asMethod.returnType
      )
}