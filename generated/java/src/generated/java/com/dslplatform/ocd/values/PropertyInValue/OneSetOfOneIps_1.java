package com.dslplatform.ocd.values.PropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneSetOfOneIps_1 implements java.io.Serializable {
    public OneSetOfOneIps_1(
            final java.util.Set<java.net.InetAddress> oneSetOfOneIps) {
        setOneSetOfOneIps(oneSetOfOneIps);
    }

    public OneSetOfOneIps_1() {
        this.oneSetOfOneIps = new java.util.HashSet<java.net.InetAddress>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 303374251;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneSetOfOneIps_1)) return false;
        final OneSetOfOneIps_1 other = (OneSetOfOneIps_1) obj;

        if (!(this.oneSetOfOneIps.equals(other.oneSetOfOneIps))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneSetOfOneIps_1(" + oneSetOfOneIps + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.Set<java.net.InetAddress> oneSetOfOneIps;

    @JsonProperty("oneSetOfOneIps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.Set<java.net.InetAddress> getOneSetOfOneIps() {
        return oneSetOfOneIps;
    }

    public OneSetOfOneIps_1 setOneSetOfOneIps(
            final java.util.Set<java.net.InetAddress> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneSetOfOneIps\" cannot be null!");
        com.dslplatform.ocd.values.Guards.checkNulls(value);
        this.oneSetOfOneIps = value;

        return this;
    }
}