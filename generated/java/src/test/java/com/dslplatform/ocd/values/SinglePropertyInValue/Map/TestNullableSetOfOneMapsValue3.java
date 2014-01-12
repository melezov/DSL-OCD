package com.dslplatform.ocd.values.SinglePropertyInValue.Map;

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableSetOfOneMapsValue3;
import org.scalatest._;

public class TestNullableSetOfOneMapsValue3 {

    /* Testing the property field private accesss via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableSetOfOneMapsValue3.class.getDeclaredField(
                        "nullableSetOfOneMaps").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.util.Set.class,
                NullableSetOfOneMapsValue3.class.getDeclaredField(
                        "nullableSetOfOneMaps").getType());
    }

    /* Testing the property field generic type via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldGenericType() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                new Object() {
                    @SuppressWarnings("unused")
                    private final java.util.Set<java.util.Map<String, String>> nullableSetOfOneMaps = null;
                }.getClass().getDeclaredField("nullableSetOfOneMaps").getGenericType(),
                NullableSetOfOneMapsValue3.class.getDeclaredField("nullableSetOfOneMaps").getGenericType());
    }
}
