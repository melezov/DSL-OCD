package com.dslplatform.ocd.values.SinglePropertyInValue.GuidTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableArrayOfOneGuidsValue2
import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableArrayOfOneGuidsValue2
    extends OcdSpec {

    /* Testing the property field public access via reflection (no instantiation) */
    def `Test property field access`() =
      lock(
        typeOf[NullableArrayOfOneGuidsValue2]
          .member("nullableArrayOfOneGuids": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[Array[scala.util.UUID]]]
      , typeOf[NullableArrayOfOneGuidsValue2]
          .member("nullableArrayOfOneGuids": TermName)
          .asMethod.returnType
      )
}
