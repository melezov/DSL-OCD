package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.TimestampTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfNullableTimestamps_3;

public class TestNullableSetOfNullableTimestamps_3 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableSetOfNullableTimestamps_3.class.getDeclaredField(
                        "nullableSetOfNullableTimestamps").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                NullableSetOfNullableTimestamps_3.class.getDeclaredField(
                        "nullableSetOfNullableTimestamps").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<org.joda.time.DateTime> nullableSetOfNullableTimestamps = null;
                }.getClass().getDeclaredField("nullableSetOfNullableTimestamps").getGenericType(),
                NullableSetOfNullableTimestamps_3.class.getDeclaredField("nullableSetOfNullableTimestamps").getGenericType());
    }
}
