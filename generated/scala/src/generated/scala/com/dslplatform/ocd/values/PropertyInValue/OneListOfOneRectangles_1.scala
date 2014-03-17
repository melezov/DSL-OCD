package com.dslplatform.ocd.values.PropertyInValue

case class OneListOfOneRectangles_1 @com.fasterxml.jackson.annotation.JsonIgnore() (
     oneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D] = IndexedSeq.empty
  ) {

    require(oneListOfOneRectangles ne null, "Null value was provided for property \"oneListOfOneRectangles\"")
    com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneRectangles)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneRectangles") oneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D]
  ) =
    this( oneListOfOneRectangles = if (oneListOfOneRectangles == null) IndexedSeq.empty else oneListOfOneRectangles)

}