package com.dslplatform.ocd.values.SinglePropertyInValue;

import com.fasterxml.jackson.annotation.*;

public final class OneListOfNullableRectanglesValue4 implements
        java.io.Serializable {
    public OneListOfNullableRectanglesValue4(
            final java.util.List<java.awt.geom.Rectangle2D> oneListOfNullableRectangles) {
        setOneListOfNullableRectangles(oneListOfNullableRectangles);
    }

    public OneListOfNullableRectanglesValue4() {
        this.oneListOfNullableRectangles = new java.util.ArrayList<java.awt.geom.Rectangle2D>();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + 652892153;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (!(obj instanceof OneListOfNullableRectanglesValue4)) return false;
        final OneListOfNullableRectanglesValue4 other = (OneListOfNullableRectanglesValue4) obj;

        if (!(this.oneListOfNullableRectangles
                .equals(other.oneListOfNullableRectangles))) return false;

        return true;
    }

    @Override
    public String toString() {
        return "OneListOfNullableRectanglesValue4("
                + oneListOfNullableRectangles + ')';
    }

    private static final long serialVersionUID = 0x0097000a;

    private java.util.List<java.awt.geom.Rectangle2D> oneListOfNullableRectangles;

    @JsonProperty("oneListOfNullableRectangles")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public java.util.List<java.awt.geom.Rectangle2D> getOneListOfNullableRectangles() {
        return oneListOfNullableRectangles;
    }

    public OneListOfNullableRectanglesValue4 setOneListOfNullableRectangles(
            final java.util.List<java.awt.geom.Rectangle2D> value) {
        if (value == null)
            throw new IllegalArgumentException(
                    "Property \"oneListOfNullableRectangles\" cannot be null!");
        this.oneListOfNullableRectangles = value;

        return this;
    }
}
