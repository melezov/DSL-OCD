package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.LongTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfNullableLongs_3;

public class TestNullableSetOfNullableLongs_3 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableSetOfNullableLongs_3.class.getDeclaredField(
                        "nullableSetOfNullableLongs").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                NullableSetOfNullableLongs_3.class.getDeclaredField(
                        "nullableSetOfNullableLongs").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<Long> nullableSetOfNullableLongs = null;
                }.getClass().getDeclaredField("nullableSetOfNullableLongs").getGenericType(),
                NullableSetOfNullableLongs_3.class.getDeclaredField("nullableSetOfNullableLongs").getGenericType());
    }
}
