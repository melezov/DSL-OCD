package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneArrayOfOneDecimals_1 implements java.io.Serializable {
    public OneArrayOfOneDecimals_1(
            final java.math.BigDecimal[] oneArrayOfOneDecimals) {
        setOneArrayOfOneDecimals(oneArrayOfOneDecimals);
    }

    public OneArrayOfOneDecimals_1() {
        this.oneArrayOfOneDecimals = new java.math.BigDecimal[] {};
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1453704602;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneArrayOfOneDecimals_1)) return false;
        final OneArrayOfOneDecimals_1 other = (OneArrayOfOneDecimals_1) obj;

        if (!(com.dslplatform.ocd.values.Guards.compareBigDecimal(
                this.oneArrayOfOneDecimals, other.oneArrayOfOneDecimals)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneArrayOfOneDecimals_1(" + oneArrayOfOneDecimals + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.math.BigDecimal[] oneArrayOfOneDecimals;

    @JsonProperty("oneArrayOfOneDecimals")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.math.BigDecimal[] getOneArrayOfOneDecimals() {
        return oneArrayOfOneDecimals;
    }

    public OneArrayOfOneDecimals_1 setOneArrayOfOneDecimals(
            final java.math.BigDecimal[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneArrayOfOneDecimals\" cannot be null!");
        com.dslplatform.ocd.values.Guards.checkNulls(value);
        this.oneArrayOfOneDecimals = value;

        return this;
    }
}