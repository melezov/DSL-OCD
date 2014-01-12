package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class NullableListOfNullableDecimalsValue2 implements
        java.io.Serializable {
    public NullableListOfNullableDecimalsValue2(
            final java.util.List<java.math.BigDecimal> nullableListOfNullableDecimals) {
        setNullableListOfNullableDecimals(nullableListOfNullableDecimals);
    }

    public NullableListOfNullableDecimalsValue2() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 451195786;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof NullableListOfNullableDecimalsValue2))
            return false;
        final NullableListOfNullableDecimalsValue2 other = (NullableListOfNullableDecimalsValue2) obj;

        if (!(com.dslplatform.ocd.values.Guards.compareBigDecimal(
                this.nullableListOfNullableDecimals,
                other.nullableListOfNullableDecimals))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "NullableListOfNullableDecimalsValue2("
                + nullableListOfNullableDecimals + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.List<java.math.BigDecimal> nullableListOfNullableDecimals;

    @JsonProperty("nullableListOfNullableDecimals")
    public java.util.List<java.math.BigDecimal> getNullableListOfNullableDecimals() {
        return nullableListOfNullableDecimals;
    }

    public NullableListOfNullableDecimalsValue2 setNullableListOfNullableDecimals(
            final java.util.List<java.math.BigDecimal> value) {
        this.nullableListOfNullableDecimals = value;

        return this;
    }
}
