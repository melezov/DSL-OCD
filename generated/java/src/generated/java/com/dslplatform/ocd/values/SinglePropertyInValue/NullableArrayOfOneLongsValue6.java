package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class NullableArrayOfOneLongsValue6 implements
        java.io.Serializable {
    public NullableArrayOfOneLongsValue6(
            final long[] nullableArrayOfOneLongs) {
        setNullableArrayOfOneLongs(nullableArrayOfOneLongs);
    }

    public NullableArrayOfOneLongsValue6() {}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1547824157;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof NullableArrayOfOneLongsValue6)) return false;
        final NullableArrayOfOneLongsValue6 other = (NullableArrayOfOneLongsValue6) obj;

        if (!(java.util.Arrays.equals(this.nullableArrayOfOneLongs,
                other.nullableArrayOfOneLongs))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "NullableArrayOfOneLongsValue6(" + nullableArrayOfOneLongs + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private long[] nullableArrayOfOneLongs;

    @JsonProperty("nullableArrayOfOneLongs")
    public long[] getNullableArrayOfOneLongs() {
        return nullableArrayOfOneLongs;
    }

    public NullableArrayOfOneLongsValue6 setNullableArrayOfOneLongs(
            final long[] value) {
        this.nullableArrayOfOneLongs = value;

        return this;
    }
}
