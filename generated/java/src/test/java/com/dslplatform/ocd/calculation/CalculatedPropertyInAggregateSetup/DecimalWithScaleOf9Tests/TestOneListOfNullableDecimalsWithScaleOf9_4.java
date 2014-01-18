package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.DecimalWithScaleOf9Tests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfNullableDecimalsWithScaleOf9_4;

public class TestOneListOfNullableDecimalsWithScaleOf9_4 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneListOfNullableDecimalsWithScaleOf9_4.class.getDeclaredField(
                        "oneListOfNullableDecimalsWithScaleOf9").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.List.class,
                OneListOfNullableDecimalsWithScaleOf9_4.class.getDeclaredField(
                        "oneListOfNullableDecimalsWithScaleOf9").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.List<java.math.BigDecimal> oneListOfNullableDecimalsWithScaleOf9 = null;
                }.getClass().getDeclaredField("oneListOfNullableDecimalsWithScaleOf9").getGenericType(),
                OneListOfNullableDecimalsWithScaleOf9_4.class.getDeclaredField("oneListOfNullableDecimalsWithScaleOf9").getGenericType());
    }
}
