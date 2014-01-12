package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class NullableIntegerValue1 implements java.io.Serializable {
    public NullableIntegerValue1(
            final Integer nullableInteger) {
        setNullableInteger(nullableInteger);
    }

    public NullableIntegerValue1() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1325358457;
        result = prime
                * result
                + (this.nullableInteger != null ? this.nullableInteger
                        .hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof NullableIntegerValue1)) return false;
        final NullableIntegerValue1 other = (NullableIntegerValue1) obj;

        if (!(this.nullableInteger == other.nullableInteger || this.nullableInteger != null
                && this.nullableInteger.equals(other.nullableInteger)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "NullableIntegerValue1(" + nullableInteger + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private Integer nullableInteger;

    @JsonProperty("nullableInteger")
    public Integer getNullableInteger() {
        return nullableInteger;
    }

    public NullableIntegerValue1 setNullableInteger(final Integer value) {
        this.nullableInteger = value;

        return this;
    }
}
