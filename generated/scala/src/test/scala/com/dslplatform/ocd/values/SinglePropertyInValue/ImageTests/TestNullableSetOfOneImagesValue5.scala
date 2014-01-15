package com.dslplatform.ocd.values.SinglePropertyInValue.ImageTests

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableSetOfOneImagesValue5
import scala.reflect.runtime.universe._

@RunWith(classOf[JUnitRunner])
class TestNullableSetOfOneImagesValue5
    extends OcdSpec {

    /* Testing the property field public access via reflection (no instantiation) */
    def `Test property field access`() =
      lock(
        typeOf[NullableSetOfOneImagesValue5]
          .member("nullableSetOfOneImages": TermName)
          .asMethod.isPublic
      ) === true

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[Option[Set[java.awt.image.BufferedImage]]]
      , typeOf[NullableSetOfOneImagesValue5]
          .member("nullableSetOfOneImages": TermName)
          .asMethod.returnType
      )
}
