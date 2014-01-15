package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneListOfOneRectanglesValue1 implements java.io.Serializable {
    public OneListOfOneRectanglesValue1(
            final java.util.List<java.awt.geom.Rectangle2D> oneListOfOneRectangles) {
        setOneListOfOneRectangles(oneListOfOneRectangles);
    }

    public OneListOfOneRectanglesValue1() {
        this.oneListOfOneRectangles = new java.util.ArrayList<java.awt.geom.Rectangle2D>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 1244708965;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneListOfOneRectanglesValue1)) return false;
        final OneListOfOneRectanglesValue1 other = (OneListOfOneRectanglesValue1) obj;

        if (!(this.oneListOfOneRectangles.equals(other.oneListOfOneRectangles)))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneListOfOneRectanglesValue1(" + oneListOfOneRectangles + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.List<java.awt.geom.Rectangle2D> oneListOfOneRectangles;

    @JsonProperty("oneListOfOneRectangles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<java.awt.geom.Rectangle2D> getOneListOfOneRectangles() {
        return oneListOfOneRectangles;
    }

    public OneListOfOneRectanglesValue1 setOneListOfOneRectangles(
            final java.util.List<java.awt.geom.Rectangle2D> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneListOfOneRectangles\" cannot be null!");
        com.dslplatform.ocd.values.Guards.checkNulls(value);
        this.oneListOfOneRectangles = value;

        return this;
    }
}
