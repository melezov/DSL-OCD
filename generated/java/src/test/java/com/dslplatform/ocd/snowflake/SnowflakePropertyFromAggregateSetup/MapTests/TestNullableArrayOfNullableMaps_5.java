package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.MapTests;

import com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.NullableArrayOfNullableMaps_5;

public class TestNullableArrayOfNullableMaps_5 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableArrayOfNullableMaps_5.class.getDeclaredField(
                        "nullableArrayOfNullableMaps").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Map[].class,
                NullableArrayOfNullableMaps_5.class.getDeclaredField(
                        "nullableArrayOfNullableMaps").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Map<String, String>[] nullableArrayOfNullableMaps = null;
                }.getClass().getDeclaredField("nullableArrayOfNullableMaps").getGenericType(),
                NullableArrayOfNullableMaps_5.class.getDeclaredField("nullableArrayOfNullableMaps").getGenericType());
    }
}