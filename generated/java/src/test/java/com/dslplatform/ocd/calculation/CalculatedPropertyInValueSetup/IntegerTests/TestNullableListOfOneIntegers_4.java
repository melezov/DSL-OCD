package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup.IntegerTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup.NullableListOfOneIntegers_4;

public class TestNullableListOfOneIntegers_4 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableListOfOneIntegers_4.class.getDeclaredField(
                        "nullableListOfOneIntegers").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.List.class,
                NullableListOfOneIntegers_4.class.getDeclaredField(
                        "nullableListOfOneIntegers").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.List<Integer> nullableListOfOneIntegers = null;
                }.getClass().getDeclaredField("nullableListOfOneIntegers").getGenericType(),
                NullableListOfOneIntegers_4.class.getDeclaredField("nullableListOfOneIntegers").getGenericType());
    }
}
