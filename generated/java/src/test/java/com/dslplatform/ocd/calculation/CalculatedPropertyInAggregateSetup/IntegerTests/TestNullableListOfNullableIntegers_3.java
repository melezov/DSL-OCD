package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.IntegerTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableListOfNullableIntegers_3;

public class TestNullableListOfNullableIntegers_3 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableListOfNullableIntegers_3.class.getDeclaredField(
                        "nullableListOfNullableIntegers").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.List.class,
                NullableListOfNullableIntegers_3.class.getDeclaredField(
                        "nullableListOfNullableIntegers").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.List<Integer> nullableListOfNullableIntegers = null;
                }.getClass().getDeclaredField("nullableListOfNullableIntegers").getGenericType(),
                NullableListOfNullableIntegers_3.class.getDeclaredField("nullableListOfNullableIntegers").getGenericType());
    }
}