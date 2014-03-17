package com.dslplatform.ocd.values.PropertyInValue.DecimalWithScaleOf9Tests;

import com.dslplatform.ocd.values.PropertyInValue.OneListOfOneDecimalsWithScaleOf9_1;

public class TestOneListOfOneDecimalsWithScaleOf9_1 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneListOfOneDecimalsWithScaleOf9_1.class.getDeclaredField(
                        "oneListOfOneDecimalsWithScaleOf9").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.List.class,
                OneListOfOneDecimalsWithScaleOf9_1.class.getDeclaredField(
                        "oneListOfOneDecimalsWithScaleOf9").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.List<java.math.BigDecimal> oneListOfOneDecimalsWithScaleOf9 = null;
                }.getClass().getDeclaredField("oneListOfOneDecimalsWithScaleOf9").getGenericType(),
                OneListOfOneDecimalsWithScaleOf9_1.class.getDeclaredField("oneListOfOneDecimalsWithScaleOf9").getGenericType());
    }
}