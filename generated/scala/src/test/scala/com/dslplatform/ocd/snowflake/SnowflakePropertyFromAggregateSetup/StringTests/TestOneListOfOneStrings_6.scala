package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup
package StringTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestOneListOfOneStrings_6
    extends OcdSpec {

    /* Testing the property field public visibility via reflection (no instantiation) */
    def `Test property field visibility`() =
      lock(
        typeOf[OneListOfOneStrings_6]
          .member("oneListOfOneStrings": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[IndexedSeq[String]]
      , typeOf[OneListOfOneStrings_6]
          .member("oneListOfOneStrings": TermName)
          .asMethod.returnType
      )
}
