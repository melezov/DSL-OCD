package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup
package DoubleTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableArrayOfNullableDoubles_5
    extends OcdSpec {

    /* Testing the property field public visibility via reflection (no instantiation) */
    def `Test property field visibility`() =
      lock(
        typeOf[NullableArrayOfNullableDoubles_5]
          .member("nullableArrayOfNullableDoubles": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[Array[Option[Double]]]]
      , typeOf[NullableArrayOfNullableDoubles_5]
          .member("nullableArrayOfNullableDoubles": TermName)
          .asMethod.returnType
      )
}
