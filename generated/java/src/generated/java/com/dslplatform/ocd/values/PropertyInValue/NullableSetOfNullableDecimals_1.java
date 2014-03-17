package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class NullableSetOfNullableDecimals_1 implements
        java.io.Serializable {
    public NullableSetOfNullableDecimals_1(
            final java.util.Set<java.math.BigDecimal> nullableSetOfNullableDecimals) {
        setNullableSetOfNullableDecimals(nullableSetOfNullableDecimals);
    }

    public NullableSetOfNullableDecimals_1() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1495174045;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof NullableSetOfNullableDecimals_1)) return false;
        final NullableSetOfNullableDecimals_1 other = (NullableSetOfNullableDecimals_1) obj;

        if (!(com.dslplatform.ocd.values.Guards.compareBigDecimal(
                this.nullableSetOfNullableDecimals,
                other.nullableSetOfNullableDecimals))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "NullableSetOfNullableDecimals_1("
                + nullableSetOfNullableDecimals + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.Set<java.math.BigDecimal> nullableSetOfNullableDecimals;

    @JsonProperty("nullableSetOfNullableDecimals")
    public java.util.Set<java.math.BigDecimal> getNullableSetOfNullableDecimals() {
        return nullableSetOfNullableDecimals;
    }

    public NullableSetOfNullableDecimals_1 setNullableSetOfNullableDecimals(
            final java.util.Set<java.math.BigDecimal> value) {
        this.nullableSetOfNullableDecimals = value;

        return this;
    }
}