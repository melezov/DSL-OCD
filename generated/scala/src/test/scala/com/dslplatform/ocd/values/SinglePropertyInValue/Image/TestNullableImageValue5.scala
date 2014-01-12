package com.dslplatform.ocd.values.SinglePropertyInValue.Image

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableImageValue5

class TestNullableImageValue5
    extends SpecExtensions {

    /* Testing the property field public accesss via reflection (no instantiation) */
    def `Test property field access`() =
      assert(
        typeOf[NullableImageValue5].member("nullableImage": TermName).asMethod.isPublic
      )

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[scala.Image?]
      , typeOf[NullableImageValue5].member("nullableImage": TermName).asMethod.returnType
      )
}
