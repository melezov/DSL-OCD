package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.LocationTests;

import com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneSetOfNullableLocations_3;

public class TestOneSetOfNullableLocations_3 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneSetOfNullableLocations_3.class.getDeclaredField(
                        "oneSetOfNullableLocations").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                OneSetOfNullableLocations_3.class.getDeclaredField(
                        "oneSetOfNullableLocations").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<java.awt.geom.Point2D> oneSetOfNullableLocations = null;
                }.getClass().getDeclaredField("oneSetOfNullableLocations").getGenericType(),
                OneSetOfNullableLocations_3.class.getDeclaredField("oneSetOfNullableLocations").getGenericType());
    }
}