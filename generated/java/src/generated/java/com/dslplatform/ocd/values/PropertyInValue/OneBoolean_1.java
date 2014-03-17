package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneBoolean_1 implements java.io.Serializable {
    public OneBoolean_1(
            final boolean oneBoolean) {
        setOneBoolean(oneBoolean);
    }

    public OneBoolean_1() {
        this.oneBoolean = false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1493358078;
        result = prime * result + (this.oneBoolean ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneBoolean_1)) return false;
        final OneBoolean_1 other = (OneBoolean_1) obj;

        if (!(this.oneBoolean == other.oneBoolean)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneBoolean_1(" + oneBoolean + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private boolean oneBoolean;

    @JsonProperty("oneBoolean")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public boolean getOneBoolean() {
        return oneBoolean;
    }

    public OneBoolean_1 setOneBoolean(final boolean value) {
        this.oneBoolean = value;

        return this;
    }
}