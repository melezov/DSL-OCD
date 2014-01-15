package com.dslplatform.ocd.values.SinglePropertyInValue.IpTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableArrayOfNullableIpsValue2
import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableArrayOfNullableIpsValue2
    extends OcdSpec {

    /* Testing the property field public access via reflection (no instantiation) */
    def `Test property field access`() =
      lock(
        typeOf[NullableArrayOfNullableIpsValue2]
          .member("nullableArrayOfNullableIps": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[Array[Option[java.net.InetAddress]]]]
      , typeOf[NullableArrayOfNullableIpsValue2]
          .member("nullableArrayOfNullableIps": TermName)
          .asMethod.returnType
      )
}
