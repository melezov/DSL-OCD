package com.dslplatform.ocd.values.SinglePropertyInValue.BooleanTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableArrayOfNullableBooleansValue10
import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableArrayOfNullableBooleansValue10
    extends OcdSpec {

    /* Testing the property field public access via reflection (no instantiation) */
    def `Test property field access`() =
      lock(
        typeOf[NullableArrayOfNullableBooleansValue10]
          .member("nullableArrayOfNullableBooleans": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[Array[Option[Boolean]]]]
      , typeOf[NullableArrayOfNullableBooleansValue10]
          .member("nullableArrayOfNullableBooleans": TermName)
          .asMethod.returnType
      )
}
