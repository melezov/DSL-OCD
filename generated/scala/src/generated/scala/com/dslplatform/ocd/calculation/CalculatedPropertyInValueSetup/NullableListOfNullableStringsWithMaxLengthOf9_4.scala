package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup

case class NullableListOfNullableStringsWithMaxLengthOf9_4 @com.fasterxml.jackson.annotation.JsonIgnore() (
     nullableListOfNullableStringsWithMaxLengthOf9: Option[IndexedSeq[Option[String]]] = None,
     calculatedNullableListOfNullableStringsWithMaxLengthOf9: Option[IndexedSeq[Option[String]]] = None,
     persistedNullableListOfNullableStringsWithMaxLengthOf9: Option[IndexedSeq[Option[String]]] = None
  ) {

    require(nullableListOfNullableStringsWithMaxLengthOf9 ne null, "Null value was provided for property \"nullableListOfNullableStringsWithMaxLengthOf9\"")
    if (nullableListOfNullableStringsWithMaxLengthOf9.isDefined) require(nullableListOfNullableStringsWithMaxLengthOf9.get ne null, "Null value was provided for property \"nullableListOfNullableStringsWithMaxLengthOf9\"")
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableListOfNullableStringsWithMaxLengthOf9)
    com.dslplatform.api.Guards.checkCollectionOptionLength(nullableListOfNullableStringsWithMaxLengthOf9, 9)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableListOfNullableStringsWithMaxLengthOf9") nullableListOfNullableStringsWithMaxLengthOf9: Option[IndexedSeq[Option[String]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableListOfNullableStringsWithMaxLengthOf9") calculatedNullableListOfNullableStringsWithMaxLengthOf9: Option[IndexedSeq[Option[String]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableListOfNullableStringsWithMaxLengthOf9") persistedNullableListOfNullableStringsWithMaxLengthOf9: Option[IndexedSeq[Option[String]]]
  ) =
    this( nullableListOfNullableStringsWithMaxLengthOf9 = nullableListOfNullableStringsWithMaxLengthOf9, calculatedNullableListOfNullableStringsWithMaxLengthOf9 = calculatedNullableListOfNullableStringsWithMaxLengthOf9, persistedNullableListOfNullableStringsWithMaxLengthOf9 = persistedNullableListOfNullableStringsWithMaxLengthOf9)

}