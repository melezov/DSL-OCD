package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup
package RectangleTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableArrayOfOneRectangles_3
    extends OcdSpec {

    /* Testing the property field public visibility via reflection (no instantiation) */
    def `Test property field visibility`() =
      lock(
        typeOf[NullableArrayOfOneRectangles_3]
          .member("nullableArrayOfOneRectangles": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[Array[java.awt.geom.Rectangle2D]]]
      , typeOf[NullableArrayOfOneRectangles_3]
          .member("nullableArrayOfOneRectangles": TermName)
          .asMethod.returnType
      )
}
