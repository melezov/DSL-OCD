package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneSetOfNullableIntegersValue5 implements
        java.io.Serializable {
    public OneSetOfNullableIntegersValue5(
            final java.util.Set<Integer> oneSetOfNullableIntegers) {
        setOneSetOfNullableIntegers(oneSetOfNullableIntegers);
    }

    public OneSetOfNullableIntegersValue5() {
        this.oneSetOfNullableIntegers = new java.util.HashSet<Integer>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1555145179;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneSetOfNullableIntegersValue5)) return false;
        final OneSetOfNullableIntegersValue5 other = (OneSetOfNullableIntegersValue5) obj;

        if (!(this.oneSetOfNullableIntegers
                .equals(other.oneSetOfNullableIntegers))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneSetOfNullableIntegersValue5(" + oneSetOfNullableIntegers
                + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.Set<Integer> oneSetOfNullableIntegers;

    @JsonProperty("oneSetOfNullableIntegers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<Integer> getOneSetOfNullableIntegers() {
        return oneSetOfNullableIntegers;
    }

    public OneSetOfNullableIntegersValue5 setOneSetOfNullableIntegers(
            final java.util.Set<Integer> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneSetOfNullableIntegers\" cannot be null!");
        this.oneSetOfNullableIntegers = value;

        return this;
    }
}
