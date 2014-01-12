package com.dslplatform.ocd.values.SinglePropertyInValue.Point

import com.dslplatform.ocd.values.SinglePropertyInValue.OneArrayOfNullablePointsValue1

class TestOneArrayOfNullablePointsValue1
    extends SpecExtensions {

    /* Testing the property field public accesss via reflection (no instantiation) */
    def `Test property field access`() =
      assert(
        typeOf[OneArrayOfNullablePointsValue1].member("oneArrayOfNullablePoints": TermName).asMethod.isPublic
      )

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[scala.Point?[]]
      , typeOf[OneArrayOfNullablePointsValue1].member("oneArrayOfNullablePoints": TermName).asMethod.returnType
      )
}
