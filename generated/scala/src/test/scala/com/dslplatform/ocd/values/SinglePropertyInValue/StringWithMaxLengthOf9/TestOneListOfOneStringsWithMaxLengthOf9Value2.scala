package com.dslplatform.ocd.values.SinglePropertyInValue.StringWithMaxLengthOf9

import com.dslplatform.ocd.values.SinglePropertyInValue.OneListOfOneStringsWithMaxLengthOf9Value2

class TestOneListOfOneStringsWithMaxLengthOf9Value2
    extends SpecExtensions {

    /* Testing the property field public accesss via reflection (no instantiation) */
    def `Test property field access`() =
      assert(
        typeOf[OneListOfOneStringsWithMaxLengthOf9Value2].member("oneListOfOneStringsWithMaxLengthOf9": TermName).asMethod.isPublic
      )

    /* Testing the property field type via reflection (no instantiation) */
    def `Test property field type`() =
      checkType(
        typeOf[scala.List<String(9)>]
      , typeOf[OneListOfOneStringsWithMaxLengthOf9Value2].member("oneListOfOneStringsWithMaxLengthOf9": TermName).asMethod.returnType
      )
}
