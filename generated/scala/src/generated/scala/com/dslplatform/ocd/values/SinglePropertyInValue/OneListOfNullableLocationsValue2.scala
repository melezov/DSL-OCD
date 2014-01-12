package com.dslplatform.ocd.values.SinglePropertyInValue

case class OneListOfNullableLocationsValue2 @com.fasterxml.jackson.annotation.JsonIgnore() (
     oneListOfNullableLocations: IndexedSeq[Option[java.awt.geom.Point2D]] = IndexedSeq.empty
  ) {

    require(oneListOfNullableLocations ne null, "Null value was provided for property \"oneListOfNullableLocations\"")
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(oneListOfNullableLocations)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("oneListOfNullableLocations") oneListOfNullableLocations: IndexedSeq[Option[java.awt.geom.Point2D]]
  ) =
    this( oneListOfNullableLocations = if (oneListOfNullableLocations == null) IndexedSeq.empty else oneListOfNullableLocations)

}
