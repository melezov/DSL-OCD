package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup
package XmlTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestOneArrayOfNullableXmls_3
    extends OcdSpec {

    /* Testing the property field public visibility via reflection (no instantiation) */
    def `Test property field visibility`() =
      lock(
        typeOf[OneArrayOfNullableXmls_3]
          .member("oneArrayOfNullableXmls": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Array[Option[scala.xml.Elem]]]
      , typeOf[OneArrayOfNullableXmls_3]
          .member("oneArrayOfNullableXmls": TermName)
          .asMethod.returnType
      )
}
