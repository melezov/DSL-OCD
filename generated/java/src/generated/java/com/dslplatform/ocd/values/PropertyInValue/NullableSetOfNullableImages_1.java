package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class NullableSetOfNullableImages_1 implements
        java.io.Serializable {
    public NullableSetOfNullableImages_1(
            final java.util.Set<java.awt.image.BufferedImage> nullableSetOfNullableImages) {
        setNullableSetOfNullableImages(nullableSetOfNullableImages);
    }

    public NullableSetOfNullableImages_1() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1712490343;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof NullableSetOfNullableImages_1)) return false;
        final NullableSetOfNullableImages_1 other = (NullableSetOfNullableImages_1) obj;

        if (!(this.nullableSetOfNullableImages == other.nullableSetOfNullableImages || this.nullableSetOfNullableImages != null
                && this.nullableSetOfNullableImages
                        .equals(other.nullableSetOfNullableImages)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "NullableSetOfNullableImages_1(" + nullableSetOfNullableImages
                + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.Set<java.awt.image.BufferedImage> nullableSetOfNullableImages;

    @JsonProperty("nullableSetOfNullableImages")
    public java.util.Set<java.awt.image.BufferedImage> getNullableSetOfNullableImages() {
        return nullableSetOfNullableImages;
    }

    public NullableSetOfNullableImages_1 setNullableSetOfNullableImages(
            final java.util.Set<java.awt.image.BufferedImage> value) {
        this.nullableSetOfNullableImages = value;

        return this;
    }
}