package com.dslplatform.ocd.values.SinglePropertyInValue.DateTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.dslplatform.ocd.values.SinglePropertyInValue.OneArrayOfOneDatesValue5
import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestOneArrayOfOneDatesValue5
    extends OcdSpec {

    /* Testing the property field public access via reflection (no instantiation) */
    def `Test property field access`() =
      lock(
        typeOf[OneArrayOfOneDatesValue5]
          .member("oneArrayOfOneDates": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Array[org.joda.time.LocalDate]]
      , typeOf[OneArrayOfOneDatesValue5]
          .member("oneArrayOfOneDates": TermName)
          .asMethod.returnType
      )
}
