package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneArrayOfOneLongs_1 implements java.io.Serializable {
    public OneArrayOfOneLongs_1(
            final long[] oneArrayOfOneLongs) {
        setOneArrayOfOneLongs(oneArrayOfOneLongs);
    }

    public OneArrayOfOneLongs_1() {
        this.oneArrayOfOneLongs = new long[] {};
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1963033989;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneArrayOfOneLongs_1)) return false;
        final OneArrayOfOneLongs_1 other = (OneArrayOfOneLongs_1) obj;

        if (!(java.util.Arrays.equals(this.oneArrayOfOneLongs,
                other.oneArrayOfOneLongs))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneArrayOfOneLongs_1(" + oneArrayOfOneLongs + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private long[] oneArrayOfOneLongs;

    @JsonProperty("oneArrayOfOneLongs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public long[] getOneArrayOfOneLongs() {
        return oneArrayOfOneLongs;
    }

    public OneArrayOfOneLongs_1 setOneArrayOfOneLongs(final long[] value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneArrayOfOneLongs\" cannot be null!");
        this.oneArrayOfOneLongs = value;

        return this;
    }
}