package com.dslplatform.ocd.values.SinglePropertyInValue.StringWithMaxLengthOf9;

import com.dslplatform.ocd.values.SinglePropertyInValue.OneArrayOfOneStringsWithMaxLengthOf9Value3;
import org.scalatest._;

public class TestOneArrayOfOneStringsWithMaxLengthOf9Value3 {

    /* Testing the property field private accesss via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneArrayOfOneStringsWithMaxLengthOf9Value3.class.getDeclaredField(
                        "oneArrayOfOneStringsWithMaxLengthOf9").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                String[].class,
                OneArrayOfOneStringsWithMaxLengthOf9Value3.class.getDeclaredField(
                        "oneArrayOfOneStringsWithMaxLengthOf9").getType());
    }
}
