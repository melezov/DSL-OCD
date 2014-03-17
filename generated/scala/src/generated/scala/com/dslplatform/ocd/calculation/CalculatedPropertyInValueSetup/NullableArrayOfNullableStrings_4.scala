package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup

case class NullableArrayOfNullableStrings_4 @com.fasterxml.jackson.annotation.JsonIgnore() (
     nullableArrayOfNullableStrings: Option[Array[Option[String]]] = None,
     calculatedNullableArrayOfNullableStrings: Option[Array[Option[String]]] = None,
     persistedNullableArrayOfNullableStrings: Option[Array[Option[String]]] = None
  ) {

    require(nullableArrayOfNullableStrings ne null, "Null value was provided for property \"nullableArrayOfNullableStrings\"")
    if (nullableArrayOfNullableStrings.isDefined) require(nullableArrayOfNullableStrings.get ne null, "Null value was provided for property \"nullableArrayOfNullableStrings\"")
    com.dslplatform.api.Guards.checkArrayOptionRefNulls(nullableArrayOfNullableStrings)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableArrayOfNullableStrings") nullableArrayOfNullableStrings: Option[Array[Option[String]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableArrayOfNullableStrings") calculatedNullableArrayOfNullableStrings: Option[Array[Option[String]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableArrayOfNullableStrings") persistedNullableArrayOfNullableStrings: Option[Array[Option[String]]]
  ) =
    this( nullableArrayOfNullableStrings = nullableArrayOfNullableStrings, calculatedNullableArrayOfNullableStrings = calculatedNullableArrayOfNullableStrings, persistedNullableArrayOfNullableStrings = persistedNullableArrayOfNullableStrings)

}