package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup
package StringTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableSetOfNullableStrings_3
    extends OcdSpec {

    /* Testing the property field public visibility via reflection (no instantiation) */
    def `Test property field visibility`() =
      lock(
        typeOf[NullableSetOfNullableStrings_3]
          .member("nullableSetOfNullableStrings": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[Set[Option[String]]]]
      , typeOf[NullableSetOfNullableStrings_3]
          .member("nullableSetOfNullableStrings": TermName)
          .asMethod.returnType
      )
}