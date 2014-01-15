package com.dslplatform.ocd.values.SinglePropertyInValue.RectangleTests;

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableRectangleValue4;

public class TestNullableRectangleValue4 {

    /* Testing the property field private access via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableRectangleValue4.class.getDeclaredField(
                        "nullableRectangle").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.awt.geom.Rectangle2D.class,
                NullableRectangleValue4.class.getDeclaredField(
                        "nullableRectangle").getType());
    }
}
