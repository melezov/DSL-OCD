package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneSetOfOneDatesValue3 implements java.io.Serializable {
    public OneSetOfOneDatesValue3(
            final java.util.Set<org.joda.time.LocalDate> oneSetOfOneDates) {
        setOneSetOfOneDates(oneSetOfOneDates);
    }

    public OneSetOfOneDatesValue3() {
        this.oneSetOfOneDates = new java.util.HashSet<org.joda.time.LocalDate>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 450178956;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneSetOfOneDatesValue3)) return false;
        final OneSetOfOneDatesValue3 other = (OneSetOfOneDatesValue3) obj;

        if (!(this.oneSetOfOneDates.equals(other.oneSetOfOneDates)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneSetOfOneDatesValue3(" + oneSetOfOneDates + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.Set<org.joda.time.LocalDate> oneSetOfOneDates;

    @JsonProperty("oneSetOfOneDates")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<org.joda.time.LocalDate> getOneSetOfOneDates() {
        return oneSetOfOneDates;
    }

    public OneSetOfOneDatesValue3 setOneSetOfOneDates(
            final java.util.Set<org.joda.time.LocalDate> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneSetOfOneDates\" cannot be null!");
        com.dslplatform.ocd.values.Guards.checkNulls(value);
        this.oneSetOfOneDates = value;

        return this;
    }
}
