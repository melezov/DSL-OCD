package com.dslplatform.ocd.values.SinglePropertyInValue.PointTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.dslplatform.ocd.values.SinglePropertyInValue.OneArrayOfNullablePointsValue2
import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestOneArrayOfNullablePointsValue2
    extends OcdSpec {

    /* Testing the property field public access via reflection (no instantiation) */
    def `Test property field access`() =
      lock(
        typeOf[OneArrayOfNullablePointsValue2]
          .member("oneArrayOfNullablePoints": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Array[Option[java.awt.geom.Point2D]]]
      , typeOf[OneArrayOfNullablePointsValue2]
          .member("oneArrayOfNullablePoints": TermName)
          .asMethod.returnType
      )
}
