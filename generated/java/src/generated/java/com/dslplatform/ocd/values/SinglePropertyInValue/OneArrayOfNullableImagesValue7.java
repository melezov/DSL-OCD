package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneArrayOfNullableImagesValue7 implements
        java.io.Serializable {
    public OneArrayOfNullableImagesValue7(
            final java.awt.image.BufferedImage[] oneArrayOfNullableImages) {
        setOneArrayOfNullableImages(oneArrayOfNullableImages);
    }

    public OneArrayOfNullableImagesValue7() {
        this.oneArrayOfNullableImages = new java.awt.image.BufferedImage[] {};
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 2013410781;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneArrayOfNullableImagesValue7)) return false;
        final OneArrayOfNullableImagesValue7 other = (OneArrayOfNullableImagesValue7) obj;

        if (!(java.util.Arrays.equals(this.oneArrayOfNullableImages,
                other.oneArrayOfNullableImages))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneArrayOfNullableImagesValue7(" + oneArrayOfNullableImages
                + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.awt.image.BufferedImage[] oneArrayOfNullableImages;

    @JsonProperty("oneArrayOfNullableImages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.awt.image.BufferedImage[] getOneArrayOfNullableImages() {
        return oneArrayOfNullableImages;
    }

    public OneArrayOfNullableImagesValue7 setOneArrayOfNullableImages(
            final java.awt.image.BufferedImage[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneArrayOfNullableImages\" cannot be null!");
        this.oneArrayOfNullableImages = value;

        return this;
    }
}
