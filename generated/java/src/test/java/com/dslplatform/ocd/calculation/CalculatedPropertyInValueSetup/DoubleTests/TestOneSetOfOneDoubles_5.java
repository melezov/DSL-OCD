package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup.DoubleTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup.OneSetOfOneDoubles_5;

public class TestOneSetOfOneDoubles_5 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneSetOfOneDoubles_5.class.getDeclaredField(
                        "oneSetOfOneDoubles").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                OneSetOfOneDoubles_5.class.getDeclaredField(
                        "oneSetOfOneDoubles").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<Double> oneSetOfOneDoubles = null;
                }.getClass().getDeclaredField("oneSetOfOneDoubles").getGenericType(),
                OneSetOfOneDoubles_5.class.getDeclaredField("oneSetOfOneDoubles").getGenericType());
    }
}
