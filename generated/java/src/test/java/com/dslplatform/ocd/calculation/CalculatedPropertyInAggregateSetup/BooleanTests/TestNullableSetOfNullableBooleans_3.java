package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.BooleanTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfNullableBooleans_3;

public class TestNullableSetOfNullableBooleans_3 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableSetOfNullableBooleans_3.class.getDeclaredField(
                        "nullableSetOfNullableBooleans").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                NullableSetOfNullableBooleans_3.class.getDeclaredField(
                        "nullableSetOfNullableBooleans").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<Boolean> nullableSetOfNullableBooleans = null;
                }.getClass().getDeclaredField("nullableSetOfNullableBooleans").getGenericType(),
                NullableSetOfNullableBooleans_3.class.getDeclaredField("nullableSetOfNullableBooleans").getGenericType());
    }
}