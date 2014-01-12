package com.dslplatform.ocd.values.SinglePropertyInValue.Url;

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableListOfNullableUrlsValue1;

public class TestNullableListOfNullableUrlsValue1 {

    /* Testing the property field private accesss via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableListOfNullableUrlsValue1.class.getDeclaredField(
                        "nullableListOfNullableUrls").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.List.class,
                NullableListOfNullableUrlsValue1.class.getDeclaredField(
                        "nullableListOfNullableUrls").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.List<java.net.URL> nullableListOfNullableUrls = null;
                }.getClass().getDeclaredField("nullableListOfNullableUrls").getGenericType(),
                NullableListOfNullableUrlsValue1.class.getDeclaredField("nullableListOfNullableUrls").getGenericType());
    }
}
