package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.DecimalTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfOneDecimals_3;

public class TestNullableSetOfOneDecimals_3 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableSetOfOneDecimals_3.class.getDeclaredField(
                        "nullableSetOfOneDecimals").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                NullableSetOfOneDecimals_3.class.getDeclaredField(
                        "nullableSetOfOneDecimals").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<java.math.BigDecimal> nullableSetOfOneDecimals = null;
                }.getClass().getDeclaredField("nullableSetOfOneDecimals").getGenericType(),
                NullableSetOfOneDecimals_3.class.getDeclaredField("nullableSetOfOneDecimals").getGenericType());
    }
}