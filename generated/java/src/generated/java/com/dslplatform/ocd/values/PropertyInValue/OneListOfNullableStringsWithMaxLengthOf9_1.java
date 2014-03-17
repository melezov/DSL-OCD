package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneListOfNullableStringsWithMaxLengthOf9_1 implements
        java.io.Serializable {
    public OneListOfNullableStringsWithMaxLengthOf9_1(
            final java.util.List<String> oneListOfNullableStringsWithMaxLengthOf9) {
        setOneListOfNullableStringsWithMaxLengthOf9(oneListOfNullableStringsWithMaxLengthOf9);
    }

    public OneListOfNullableStringsWithMaxLengthOf9_1() {
        this.oneListOfNullableStringsWithMaxLengthOf9 = new java.util.ArrayList<String>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 251692818;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneListOfNullableStringsWithMaxLengthOf9_1))
            return false;
        final OneListOfNullableStringsWithMaxLengthOf9_1 other = (OneListOfNullableStringsWithMaxLengthOf9_1) obj;

        if (!(this.oneListOfNullableStringsWithMaxLengthOf9
                .equals(other.oneListOfNullableStringsWithMaxLengthOf9)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneListOfNullableStringsWithMaxLengthOf9_1("
                + oneListOfNullableStringsWithMaxLengthOf9 + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.List<String> oneListOfNullableStringsWithMaxLengthOf9;

    @JsonProperty("oneListOfNullableStringsWithMaxLengthOf9")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<String> getOneListOfNullableStringsWithMaxLengthOf9() {
        return oneListOfNullableStringsWithMaxLengthOf9;
    }

    public OneListOfNullableStringsWithMaxLengthOf9_1 setOneListOfNullableStringsWithMaxLengthOf9(
            final java.util.List<String> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneListOfNullableStringsWithMaxLengthOf9\" cannot be null!");
        com.dslplatform.ocd.values.Guards.checkLength(value, 9);
        this.oneListOfNullableStringsWithMaxLengthOf9 = value;

        return this;
    }
}