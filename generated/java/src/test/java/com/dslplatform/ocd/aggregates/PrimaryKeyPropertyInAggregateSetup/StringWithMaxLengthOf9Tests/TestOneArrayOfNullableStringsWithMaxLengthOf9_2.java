package com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.StringWithMaxLengthOf9Tests;

import com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneArrayOfNullableStringsWithMaxLengthOf9_2;

public class TestOneArrayOfNullableStringsWithMaxLengthOf9_2 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneArrayOfNullableStringsWithMaxLengthOf9_2.class.getDeclaredField(
                        "oneArrayOfNullableStringsWithMaxLengthOf9").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                String[].class,
                OneArrayOfNullableStringsWithMaxLengthOf9_2.class.getDeclaredField(
                        "oneArrayOfNullableStringsWithMaxLengthOf9").getType());
    }
}