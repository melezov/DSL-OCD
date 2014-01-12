package com.dslplatform.ocd.values.SinglePropertyInValue.Boolean

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableSetOfOneBooleansValue3

class TestNullableSetOfOneBooleansValue3
    extends SpecExtensions {

    /* Testing the property field public accesss via reflection (no instantiation) */
    def `Test property field access`() =
      assert(
        typeOf[NullableSetOfOneBooleansValue3].member("nullableSetOfOneBooleans": TermName).asMethod.isPublic
      )

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[scala.Set<Boolean>?]
      , typeOf[NullableSetOfOneBooleansValue3].member("nullableSetOfOneBooleans": TermName).asMethod.returnType
      )
}
