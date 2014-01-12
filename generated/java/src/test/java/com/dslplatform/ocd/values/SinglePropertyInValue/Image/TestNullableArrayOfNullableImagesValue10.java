package com.dslplatform.ocd.values.SinglePropertyInValue.Image;

import com.dslplatform.ocd.values.SinglePropertyInValue.NullableArrayOfNullableImagesValue10;

public class TestNullableArrayOfNullableImagesValue10 {

    /* Testing the property field private accesss via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldAccess() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.lang.reflect.Modifier.PRIVATE,
                NullableArrayOfNullableImagesValue10.class.getDeclaredField(
                        "nullableArrayOfNullableImages").getModifiers());
    }

    /* Testing the property field class via reflection (no instantiation) */
    @org.junit.Test
    public void testPropertyFieldClass() throws NoSuchFieldException {
        org.junit.Assert.assertEquals(
                java.awt.image.BufferedImage[].class,
                NullableArrayOfNullableImagesValue10.class.getDeclaredField(
                        "nullableArrayOfNullableImages").getType());
    }
}
