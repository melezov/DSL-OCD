package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneArrayOfOneFloats_1 implements java.io.Serializable {
    public OneArrayOfOneFloats_1(
            final float[] oneArrayOfOneFloats) {
        setOneArrayOfOneFloats(oneArrayOfOneFloats);
    }

    public OneArrayOfOneFloats_1() {
        this.oneArrayOfOneFloats = new float[] {};
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 844884179;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneArrayOfOneFloats_1)) return false;
        final OneArrayOfOneFloats_1 other = (OneArrayOfOneFloats_1) obj;

        if (!(java.util.Arrays.equals(this.oneArrayOfOneFloats,
                other.oneArrayOfOneFloats))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneArrayOfOneFloats_1(" + oneArrayOfOneFloats + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private float[] oneArrayOfOneFloats;

    @JsonProperty("oneArrayOfOneFloats")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public float[] getOneArrayOfOneFloats() {
        return oneArrayOfOneFloats;
    }

    public OneArrayOfOneFloats_1 setOneArrayOfOneFloats(final float[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneArrayOfOneFloats\" cannot be null!");
        this.oneArrayOfOneFloats = value;

        return this;
    }
}