package com.dslplatform.ocd.values.SinglePropertyInValue.Map;

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableArrayOfOneMapsValue8;

public class TestNullableArrayOfOneMapsValue8 {

    /* Testing the property field private accesss via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableArrayOfOneMapsValue8.class.getDeclaredField(
                        "nullableArrayOfOneMaps").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Map[].class,
                NullableArrayOfOneMapsValue8.class.getDeclaredField(
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
                NullableArrayOfOneMapsValue8.class.getDeclaredField("nullableArrayOfOneMaps").getGenericType());
    }
}
