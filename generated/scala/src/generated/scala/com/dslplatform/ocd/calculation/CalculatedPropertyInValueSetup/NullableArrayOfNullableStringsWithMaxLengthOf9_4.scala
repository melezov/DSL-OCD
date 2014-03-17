package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup

case class NullableArrayOfNullableStringsWithMaxLengthOf9_4 @com.fasterxml.jackson.annotation.JsonIgnore() (
     nullableArrayOfNullableStringsWithMaxLengthOf9: Option[Array[Option[String]]] = None,
     calculatedNullableArrayOfNullableStringsWithMaxLengthOf9: Option[Array[Option[String]]] = None,
     persistedNullableArrayOfNullableStringsWithMaxLengthOf9: Option[Array[Option[String]]] = None
  ) {

    require(nullableArrayOfNullableStringsWithMaxLengthOf9 ne null, "Null value was provided for property \"nullableArrayOfNullableStringsWithMaxLengthOf9\"")
    if (nullableArrayOfNullableStringsWithMaxLengthOf9.isDefined) require(nullableArrayOfNullableStringsWithMaxLengthOf9.get ne null, "Null value was provided for property \"nullableArrayOfNullableStringsWithMaxLengthOf9\"")
    com.dslplatform.api.Guards.checkArrayOptionRefNulls(nullableArrayOfNullableStringsWithMaxLengthOf9)
    com.dslplatform.api.Guards.checkArrayOptionLength(nullableArrayOfNullableStringsWithMaxLengthOf9, 9)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableArrayOfNullableStringsWithMaxLengthOf9") nullableArrayOfNullableStringsWithMaxLengthOf9: Option[Array[Option[String]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableArrayOfNullableStringsWithMaxLengthOf9") calculatedNullableArrayOfNullableStringsWithMaxLengthOf9: Option[Array[Option[String]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableArrayOfNullableStringsWithMaxLengthOf9") persistedNullableArrayOfNullableStringsWithMaxLengthOf9: Option[Array[Option[String]]]
  ) =
    this( nullableArrayOfNullableStringsWithMaxLengthOf9 = nullableArrayOfNullableStringsWithMaxLengthOf9, calculatedNullableArrayOfNullableStringsWithMaxLengthOf9 = calculatedNullableArrayOfNullableStringsWithMaxLengthOf9, persistedNullableArrayOfNullableStringsWithMaxLengthOf9 = persistedNullableArrayOfNullableStringsWithMaxLengthOf9)

}