package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneSetOfNullableDecimalsWithScaleOf9Value2 implements
        java.io.Serializable {
    public OneSetOfNullableDecimalsWithScaleOf9Value2(
            final java.util.Set<java.math.BigDecimal> oneSetOfNullableDecimalsWithScaleOf9) {
        setOneSetOfNullableDecimalsWithScaleOf9(oneSetOfNullableDecimalsWithScaleOf9);
    }

    public OneSetOfNullableDecimalsWithScaleOf9Value2() {
        this.oneSetOfNullableDecimalsWithScaleOf9 = new java.util.HashSet<java.math.BigDecimal>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1453728325;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneSetOfNullableDecimalsWithScaleOf9Value2))
            return false;
        final OneSetOfNullableDecimalsWithScaleOf9Value2 other = (OneSetOfNullableDecimalsWithScaleOf9Value2) obj;

        if (!(com.dslplatform.ocd.values.Guards.compareBigDecimal(
                this.oneSetOfNullableDecimalsWithScaleOf9,
                other.oneSetOfNullableDecimalsWithScaleOf9))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneSetOfNullableDecimalsWithScaleOf9Value2("
                + oneSetOfNullableDecimalsWithScaleOf9 + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.Set<java.math.BigDecimal> oneSetOfNullableDecimalsWithScaleOf9;

    @JsonProperty("oneSetOfNullableDecimalsWithScaleOf9")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<java.math.BigDecimal> getOneSetOfNullableDecimalsWithScaleOf9() {
        return oneSetOfNullableDecimalsWithScaleOf9;
    }

    public OneSetOfNullableDecimalsWithScaleOf9Value2 setOneSetOfNullableDecimalsWithScaleOf9(
            final java.util.Set<java.math.BigDecimal> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneSetOfNullableDecimalsWithScaleOf9\" cannot be null!");
        com.dslplatform.ocd.values.Guards.checkScale(value, 9);
        this.oneSetOfNullableDecimalsWithScaleOf9 = value;

        return this;
    }
}
