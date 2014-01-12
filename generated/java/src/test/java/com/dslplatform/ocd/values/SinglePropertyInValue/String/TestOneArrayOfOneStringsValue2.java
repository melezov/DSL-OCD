package com.dslplatform.ocd.values.SinglePropertyInValue.String;

import com.dslplatform.ocd.values.SinglePropertyInValue.OneArrayOfOneStringsValue2;

public class TestOneArrayOfOneStringsValue2 {

    /* Testing the property field private accesss via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneArrayOfOneStringsValue2.class.getDeclaredField(
                        "oneArrayOfOneStrings").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                String[].class,
                OneArrayOfOneStringsValue2.class.getDeclaredField(
                        "oneArrayOfOneStrings").getType());
    }
}
