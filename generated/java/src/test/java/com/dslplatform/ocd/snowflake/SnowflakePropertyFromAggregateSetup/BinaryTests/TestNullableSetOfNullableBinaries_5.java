package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.BinaryTests;

import com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.NullableSetOfNullableBinaries_5;

public class TestNullableSetOfNullableBinaries_5 {

    /* Testing the property field private visibility via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldVisibility() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableSetOfNullableBinaries_5.class.getDeclaredField(
                        "nullableSetOfNullableBinaries").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                NullableSetOfNullableBinaries_5.class.getDeclaredField(
                        "nullableSetOfNullableBinaries").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<byte[]> nullableSetOfNullableBinaries = null;
                }.getClass().getDeclaredField("nullableSetOfNullableBinaries").getGenericType(),
                NullableSetOfNullableBinaries_5.class.getDeclaredField("nullableSetOfNullableBinaries").getGenericType());
    }
}