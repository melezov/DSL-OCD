package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class NullableArrayOfOneDecimalsWithScaleOf9Value5 implements
        java.io.Serializable {
    public NullableArrayOfOneDecimalsWithScaleOf9Value5(
            final java.math.BigDecimal[] nullableArrayOfOneDecimalsWithScaleOf9) {
        setNullableArrayOfOneDecimalsWithScaleOf9(nullableArrayOfOneDecimalsWithScaleOf9);
    }

    public NullableArrayOfOneDecimalsWithScaleOf9Value5() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1383405867;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof NullableArrayOfOneDecimalsWithScaleOf9Value5))
            return false;
        final NullableArrayOfOneDecimalsWithScaleOf9Value5 other = (NullableArrayOfOneDecimalsWithScaleOf9Value5) obj;

        if (!(com.dslplatform.ocd.values.Guards.compareBigDecimal(
                this.nullableArrayOfOneDecimalsWithScaleOf9,
                other.nullableArrayOfOneDecimalsWithScaleOf9))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "NullableArrayOfOneDecimalsWithScaleOf9Value5("
                + nullableArrayOfOneDecimalsWithScaleOf9 + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.math.BigDecimal[] nullableArrayOfOneDecimalsWithScaleOf9;

    @JsonProperty("nullableArrayOfOneDecimalsWithScaleOf9")
    public java.math.BigDecimal[] getNullableArrayOfOneDecimalsWithScaleOf9() {
        return nullableArrayOfOneDecimalsWithScaleOf9;
    }

    public NullableArrayOfOneDecimalsWithScaleOf9Value5 setNullableArrayOfOneDecimalsWithScaleOf9(
            final java.math.BigDecimal[] value) {
        com.dslplatform.ocd.values.Guards.checkNulls(value);
        if (value != null)
            com.dslplatform.ocd.values.Guards.checkScale(value, 9);
        this.nullableArrayOfOneDecimalsWithScaleOf9 = value;

        return this;
    }
}
