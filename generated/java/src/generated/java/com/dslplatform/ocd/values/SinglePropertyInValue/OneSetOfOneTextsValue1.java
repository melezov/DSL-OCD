package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneSetOfOneTextsValue1 implements java.io.Serializable {
    public OneSetOfOneTextsValue1(
            final java.util.Set<String> oneSetOfOneTexts) {
        setOneSetOfOneTexts(oneSetOfOneTexts);
    }

    public OneSetOfOneTextsValue1() {
        this.oneSetOfOneTexts = new java.util.HashSet<String>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1078427497;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneSetOfOneTextsValue1)) return false;
        final OneSetOfOneTextsValue1 other = (OneSetOfOneTextsValue1) obj;

        if (!(this.oneSetOfOneTexts.equals(other.oneSetOfOneTexts)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneSetOfOneTextsValue1(" + oneSetOfOneTexts + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.Set<String> oneSetOfOneTexts;

    @JsonProperty("oneSetOfOneTexts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<String> getOneSetOfOneTexts() {
        return oneSetOfOneTexts;
    }

    public OneSetOfOneTextsValue1 setOneSetOfOneTexts(
            final java.util.Set<String> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneSetOfOneTexts\" cannot be null!");
        com.dslplatform.ocd.values.Guards.checkNulls(value);
        this.oneSetOfOneTexts = value;

        return this;
    }
}
