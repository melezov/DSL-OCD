package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneListOfNullableMoniesValue3 implements
        java.io.Serializable {
    public OneListOfNullableMoniesValue3(
            final java.util.List<java.math.BigDecimal> oneListOfNullableMonies) {
        setOneListOfNullableMonies(oneListOfNullableMonies);
    }

    public OneListOfNullableMoniesValue3() {
        this.oneListOfNullableMonies = new java.util.ArrayList<java.math.BigDecimal>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1598341081;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneListOfNullableMoniesValue3)) return false;
        final OneListOfNullableMoniesValue3 other = (OneListOfNullableMoniesValue3) obj;

        if (!(com.dslplatform.ocd.values.Guards.compareBigDecimal(
                this.oneListOfNullableMonies, other.oneListOfNullableMonies)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneListOfNullableMoniesValue3(" + oneListOfNullableMonies + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.List<java.math.BigDecimal> oneListOfNullableMonies;

    @JsonProperty("oneListOfNullableMonies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<java.math.BigDecimal> getOneListOfNullableMonies() {
        return oneListOfNullableMonies;
    }

    public OneListOfNullableMoniesValue3 setOneListOfNullableMonies(
            final java.util.List<java.math.BigDecimal> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneListOfNullableMonies\" cannot be null!");
        this.oneListOfNullableMonies = value;

        this.oneListOfNullableMonies = com.dslplatform.ocd.values.Guards
                .setScale(this.oneListOfNullableMonies, 2);
        return this;
    }
}
