package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.MapTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableArrayOfOneMaps_3;

public class TestNullableArrayOfOneMaps_3 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableArrayOfOneMaps_3.class.getDeclaredField(
                        "nullableArrayOfOneMaps").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Map[].class,
                NullableArrayOfOneMaps_3.class.getDeclaredField(
                        "nullableArrayOfOneMaps").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Map<String, String>[] nullableArrayOfOneMaps = null;
                }.getClass().getDeclaredField("nullableArrayOfOneMaps").getGenericType(),
                NullableArrayOfOneMaps_3.class.getDeclaredField("nullableArrayOfOneMaps").getGenericType());
    }
}