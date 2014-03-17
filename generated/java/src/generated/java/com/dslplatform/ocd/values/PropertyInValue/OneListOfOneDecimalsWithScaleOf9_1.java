package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneListOfOneDecimalsWithScaleOf9_1 implements
        java.io.Serializable {
    public OneListOfOneDecimalsWithScaleOf9_1(
            final java.util.List<java.math.BigDecimal> oneListOfOneDecimalsWithScaleOf9) {
        setOneListOfOneDecimalsWithScaleOf9(oneListOfOneDecimalsWithScaleOf9);
    }

    public OneListOfOneDecimalsWithScaleOf9_1() {
        this.oneListOfOneDecimalsWithScaleOf9 = new java.util.ArrayList<java.math.BigDecimal>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 69801039;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneListOfOneDecimalsWithScaleOf9_1)) return false;
        final OneListOfOneDecimalsWithScaleOf9_1 other = (OneListOfOneDecimalsWithScaleOf9_1) obj;

        if (!(com.dslplatform.ocd.values.Guards.compareBigDecimal(
                this.oneListOfOneDecimalsWithScaleOf9,
                other.oneListOfOneDecimalsWithScaleOf9))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneListOfOneDecimalsWithScaleOf9_1("
                + oneListOfOneDecimalsWithScaleOf9 + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.List<java.math.BigDecimal> oneListOfOneDecimalsWithScaleOf9;

    @JsonProperty("oneListOfOneDecimalsWithScaleOf9")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<java.math.BigDecimal> getOneListOfOneDecimalsWithScaleOf9() {
        return oneListOfOneDecimalsWithScaleOf9;
    }

    public OneListOfOneDecimalsWithScaleOf9_1 setOneListOfOneDecimalsWithScaleOf9(
            final java.util.List<java.math.BigDecimal> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneListOfOneDecimalsWithScaleOf9\" cannot be null!");
        com.dslplatform.ocd.values.Guards.checkNulls(value);
        com.dslplatform.ocd.values.Guards.checkScale(value, 9);
        this.oneListOfOneDecimalsWithScaleOf9 = value;

        return this;
    }
}