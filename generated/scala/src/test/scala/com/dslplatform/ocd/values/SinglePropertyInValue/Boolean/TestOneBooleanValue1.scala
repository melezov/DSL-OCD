package com.dslplatform.ocd.values.SinglePropertyInValue.Boolean

import com.dslplatform.ocd.values.SinglePropertyInValue.OneBooleanValue1

class TestOneBooleanValue1
    extends SpecExtensions {

    /* Testing the property field public accesss via reflection (no instantiation) */
    def `Test property field access`() =
      assert(
        typeOf[OneBooleanValue1].member("oneBoolean": TermName).asMethod.isPublic
      )

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[scala.Boolean]
      , typeOf[OneBooleanValue1].member("oneBoolean": TermName).asMethod.returnType
      )
}
