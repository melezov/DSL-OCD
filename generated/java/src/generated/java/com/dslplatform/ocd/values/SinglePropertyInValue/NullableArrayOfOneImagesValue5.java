package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class NullableArrayOfOneImagesValue5 implements
        java.io.Serializable {
    public NullableArrayOfOneImagesValue5(
            final java.awt.image.BufferedImage[] nullableArrayOfOneImages) {
        setNullableArrayOfOneImages(nullableArrayOfOneImages);
    }

    public NullableArrayOfOneImagesValue5() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1697644579;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof NullableArrayOfOneImagesValue5)) return false;
        final NullableArrayOfOneImagesValue5 other = (NullableArrayOfOneImagesValue5) obj;

        if (!(java.util.Arrays.equals(this.nullableArrayOfOneImages,
                other.nullableArrayOfOneImages))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "NullableArrayOfOneImagesValue5(" + nullableArrayOfOneImages
                + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.awt.image.BufferedImage[] nullableArrayOfOneImages;

    @JsonProperty("nullableArrayOfOneImages")
    public java.awt.image.BufferedImage[] getNullableArrayOfOneImages() {
        return nullableArrayOfOneImages;
    }

    public NullableArrayOfOneImagesValue5 setNullableArrayOfOneImages(
            final java.awt.image.BufferedImage[] value) {
        com.dslplatform.ocd.values.Guards.checkNulls(value);
        this.nullableArrayOfOneImages = value;

        return this;
    }
}
