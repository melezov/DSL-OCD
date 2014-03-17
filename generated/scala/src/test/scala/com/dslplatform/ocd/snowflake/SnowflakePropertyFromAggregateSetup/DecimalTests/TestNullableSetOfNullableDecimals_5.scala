package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup
package DecimalTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableSetOfNullableDecimals_5
    extends OcdSpec {

    /* Testing the property field public visibility via reflection (no instantiation) */
    def `Test property field visibility`() =
      lock(
        typeOf[NullableSetOfNullableDecimals_5]
          .member("nullableSetOfNullableDecimals": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[Set[Option[BigDecimal]]]]
      , typeOf[NullableSetOfNullableDecimals_5]
          .member("nullableSetOfNullableDecimals": TermName)
          .asMethod.returnType
      )
}