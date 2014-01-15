package com.dslplatform.ocd.values.SinglePropertyInValue.BinaryTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.dslplatform.ocd.values.SinglePropertyInValue.OneSetOfNullableBinariesValue1
import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestOneSetOfNullableBinariesValue1
    extends OcdSpec {

    /* Testing the property field public access via reflection (no instantiation) */
    def `Test property field access`() =
      lock(
        typeOf[OneSetOfNullableBinariesValue1]
          .member("oneSetOfNullableBinaries": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Set[Option[Array[Byte]]]]
      , typeOf[OneSetOfNullableBinariesValue1]
          .member("oneSetOfNullableBinaries": TermName)
          .asMethod.returnType
      )
}
