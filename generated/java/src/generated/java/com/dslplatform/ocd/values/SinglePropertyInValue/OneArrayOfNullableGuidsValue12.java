package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneArrayOfNullableGuidsValue12 implements
        java.io.Serializable {
    public OneArrayOfNullableGuidsValue12(
            final java.util.UUID[] oneArrayOfNullableGuids) {
        setOneArrayOfNullableGuids(oneArrayOfNullableGuids);
    }

    public OneArrayOfNullableGuidsValue12() {
        this.oneArrayOfNullableGuids = new java.util.UUID[] {};
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1583280605;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneArrayOfNullableGuidsValue12)) return false;
        final OneArrayOfNullableGuidsValue12 other = (OneArrayOfNullableGuidsValue12) obj;

        if (!(java.util.Arrays.equals(this.oneArrayOfNullableGuids,
                other.oneArrayOfNullableGuids))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneArrayOfNullableGuidsValue12(" + oneArrayOfNullableGuids
                + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.UUID[] oneArrayOfNullableGuids;

    @JsonProperty("oneArrayOfNullableGuids")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.UUID[] getOneArrayOfNullableGuids() {
        return oneArrayOfNullableGuids;
    }

    public OneArrayOfNullableGuidsValue12 setOneArrayOfNullableGuids(
            final java.util.UUID[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneArrayOfNullableGuids\" cannot be null!");
        this.oneArrayOfNullableGuids = value;

        return this;
    }
}
