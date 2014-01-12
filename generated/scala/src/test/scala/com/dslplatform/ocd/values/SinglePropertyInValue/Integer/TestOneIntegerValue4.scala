package com.dslplatform.ocd.values.SinglePropertyInValue.Integer

import com.dslplatform.ocd.values.SinglePropertyInValue.OneIntegerValue4

class TestOneIntegerValue4
    extends SpecExtensions {

    /* Testing the property field public accesss via reflection (no instantiation) */
    def `Test property field access`() =
      assert(
        typeOf[OneIntegerValue4].member("oneInteger": TermName).asMethod.isPublic
      )

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[scala.Integer]
      , typeOf[OneIntegerValue4].member("oneInteger": TermName).asMethod.returnType
      )
}
