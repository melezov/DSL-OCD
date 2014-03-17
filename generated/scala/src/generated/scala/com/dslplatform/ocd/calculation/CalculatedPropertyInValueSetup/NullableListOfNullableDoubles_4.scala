package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup

case class NullableListOfNullableDoubles_4 @com.fasterxml.jackson.annotation.JsonIgnore() (
     nullableListOfNullableDoubles: Option[IndexedSeq[Option[Double]]] = None,
     calculatedNullableListOfNullableDoubles: Option[IndexedSeq[Option[Double]]] = None,
     persistedNullableListOfNullableDoubles: Option[IndexedSeq[Option[Double]]] = None
  ) {

    require(nullableListOfNullableDoubles ne null, "Null value was provided for property \"nullableListOfNullableDoubles\"")
    if (nullableListOfNullableDoubles.isDefined) require(nullableListOfNullableDoubles.get ne null, "Null value was provided for property \"nullableListOfNullableDoubles\"")
    com.dslplatform.api.Guards.checkCollectionOptionValNulls(nullableListOfNullableDoubles)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableListOfNullableDoubles") nullableListOfNullableDoubles: Option[IndexedSeq[Option[Double]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableListOfNullableDoubles") calculatedNullableListOfNullableDoubles: Option[IndexedSeq[Option[Double]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableListOfNullableDoubles") persistedNullableListOfNullableDoubles: Option[IndexedSeq[Option[Double]]]
  ) =
    this( nullableListOfNullableDoubles = nullableListOfNullableDoubles, calculatedNullableListOfNullableDoubles = calculatedNullableListOfNullableDoubles, persistedNullableListOfNullableDoubles = persistedNullableListOfNullableDoubles)

}