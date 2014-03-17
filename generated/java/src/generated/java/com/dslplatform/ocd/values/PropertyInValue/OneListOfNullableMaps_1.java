package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneListOfNullableMaps_1 implements java.io.Serializable {
    public OneListOfNullableMaps_1(
            final java.util.List<java.util.Map<String, String>> oneListOfNullableMaps) {
        setOneListOfNullableMaps(oneListOfNullableMaps);
    }

    public OneListOfNullableMaps_1() {
        this.oneListOfNullableMaps = new java.util.ArrayList<java.util.Map<String, String>>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1944607895;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneListOfNullableMaps_1)) return false;
        final OneListOfNullableMaps_1 other = (OneListOfNullableMaps_1) obj;

        if (!(this.oneListOfNullableMaps.equals(other.oneListOfNullableMaps)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneListOfNullableMaps_1(" + oneListOfNullableMaps + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.List<java.util.Map<String, String>> oneListOfNullableMaps;

    @JsonProperty("oneListOfNullableMaps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<java.util.Map<String, String>> getOneListOfNullableMaps() {
        return oneListOfNullableMaps;
    }

    public OneListOfNullableMaps_1 setOneListOfNullableMaps(
            final java.util.List<java.util.Map<String, String>> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneListOfNullableMaps\" cannot be null!");
        this.oneListOfNullableMaps = value;

        return this;
    }
}