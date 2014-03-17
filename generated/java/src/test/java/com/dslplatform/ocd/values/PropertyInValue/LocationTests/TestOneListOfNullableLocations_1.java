package com.dslplatform.ocd.values.PropertyInValue.LocationTests;

import com.dslplatform.ocd.values.PropertyInValue.OneListOfNullableLocations_1;

public class TestOneListOfNullableLocations_1 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneListOfNullableLocations_1.class.getDeclaredField(
                        "oneListOfNullableLocations").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.List.class,
                OneListOfNullableLocations_1.class.getDeclaredField(
                        "oneListOfNullableLocations").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.List<java.awt.geom.Point2D> oneListOfNullableLocations = null;
                }.getClass().getDeclaredField("oneListOfNullableLocations").getGenericType(),
                OneListOfNullableLocations_1.class.getDeclaredField("oneListOfNullableLocations").getGenericType());
    }
}