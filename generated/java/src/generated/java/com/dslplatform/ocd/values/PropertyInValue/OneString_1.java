package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneString_1 implements java.io.Serializable {
    public OneString_1(
            final String oneString) {
        setOneString(oneString);
    }

    public OneString_1() {
        this.oneString = "";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1053748523;
        result = prime * result
                + (this.oneString != null ? this.oneString.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneString_1)) return false;
        final OneString_1 other = (OneString_1) obj;

        if (!(this.oneString.equals(other.oneString))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneString_1(" + oneString + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private String oneString;

    @JsonProperty("oneString")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public String getOneString() {
        return oneString;
    }

    public OneString_1 setOneString(final String value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneString\" cannot be null!");
        this.oneString = value;

        return this;
    }
}