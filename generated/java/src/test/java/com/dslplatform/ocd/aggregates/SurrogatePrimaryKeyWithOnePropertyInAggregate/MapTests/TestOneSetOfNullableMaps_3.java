package com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.MapTests;

import com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.OneSetOfNullableMaps_3;

public class TestOneSetOfNullableMaps_3 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                OneSetOfNullableMaps_3.class.getDeclaredField(
                        "oneSetOfNullableMaps").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                OneSetOfNullableMaps_3.class.getDeclaredField(
                        "oneSetOfNullableMaps").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<java.util.Map<String, String>> oneSetOfNullableMaps = null;
                }.getClass().getDeclaredField("oneSetOfNullableMaps").getGenericType(),
                OneSetOfNullableMaps_3.class.getDeclaredField("oneSetOfNullableMaps").getGenericType());
    }
}