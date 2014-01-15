package com.dslplatform.ocd.values.SinglePropertyInValue.RectangleTests;

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableArrayOfOneRectanglesValue5;

public class TestNullableArrayOfOneRectanglesValue5 {

    /* Testing the property field private access via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableArrayOfOneRectanglesValue5.class.getDeclaredField(
                        "nullableArrayOfOneRectangles").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.awt.geom.Rectangle2D[].class,
                NullableArrayOfOneRectanglesValue5.class.getDeclaredField(
                        "nullableArrayOfOneRectangles").getType());
    }
}
