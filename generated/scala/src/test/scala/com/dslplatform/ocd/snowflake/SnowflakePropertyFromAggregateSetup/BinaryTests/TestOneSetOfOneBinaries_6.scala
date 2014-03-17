package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup
package BinaryTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestOneSetOfOneBinaries_6
    extends OcdSpec {

    /* Testing the property field public visibility via reflection (no instantiation) */
    def `Test property field visibility`() =
      lock(
        typeOf[OneSetOfOneBinaries_6]
          .member("oneSetOfOneBinaries": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Set[Array[Byte]]]
      , typeOf[OneSetOfOneBinaries_6]
          .member("oneSetOfOneBinaries": TermName)
          .asMethod.returnType
      )
}