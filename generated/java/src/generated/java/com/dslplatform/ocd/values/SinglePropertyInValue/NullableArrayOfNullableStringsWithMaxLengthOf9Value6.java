package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class NullableArrayOfNullableStringsWithMaxLengthOf9Value6
        implements java.io.Serializable {
    public NullableArrayOfNullableStringsWithMaxLengthOf9Value6(
            final String[] nullableArrayOfNullableStringsWithMaxLengthOf9) {
        setNullableArrayOfNullableStringsWithMaxLengthOf9(nullableArrayOfNullableStringsWithMaxLengthOf9);
    }

    public NullableArrayOfNullableStringsWithMaxLengthOf9Value6() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 786295979;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof NullableArrayOfNullableStringsWithMaxLengthOf9Value6))
            return false;
        final NullableArrayOfNullableStringsWithMaxLengthOf9Value6 other = (NullableArrayOfNullableStringsWithMaxLengthOf9Value6) obj;

        if (!(java.util.Arrays.equals(
                this.nullableArrayOfNullableStringsWithMaxLengthOf9,
                other.nullableArrayOfNullableStringsWithMaxLengthOf9)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "NullableArrayOfNullableStringsWithMaxLengthOf9Value6("
                + nullableArrayOfNullableStringsWithMaxLengthOf9 + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private String[] nullableArrayOfNullableStringsWithMaxLengthOf9;

    @JsonProperty("nullableArrayOfNullableStringsWithMaxLengthOf9")
    public String[] getNullableArrayOfNullableStringsWithMaxLengthOf9() {
        return nullableArrayOfNullableStringsWithMaxLengthOf9;
    }

    public NullableArrayOfNullableStringsWithMaxLengthOf9Value6 setNullableArrayOfNullableStringsWithMaxLengthOf9(
            final String[] value) {
        if (value != null)
            com.dslplatform.ocd.values.Guards.checkLength(value, 9);
        this.nullableArrayOfNullableStringsWithMaxLengthOf9 = value;

        return this;
    }
}
