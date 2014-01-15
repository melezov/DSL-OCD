package com.dslplatform.ocd.values.SinglePropertyInValue.RectangleTests;

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableArrayOfOneRectanglesValue1;

public class TestNullableArrayOfOneRectanglesValue1 {

    /* Testing the property field private access via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableArrayOfOneRectanglesValue1.class.getDeclaredField(
                        "nullableArrayOfOneRectangles").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.awt.geom.Rectangle2D[].class,
                NullableArrayOfOneRectanglesValue1.class.getDeclaredField(
                        "nullableArrayOfOneRectangles").getType());
    }
}
