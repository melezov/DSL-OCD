package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup

case class NullableSetOfNullableTexts_4 @com.fasterxml.jackson.annotation.JsonIgnore() (
     nullableSetOfNullableTexts: Option[Set[Option[String]]] = None,
     calculatedNullableSetOfNullableTexts: Option[Set[Option[String]]] = None,
     persistedNullableSetOfNullableTexts: Option[Set[Option[String]]] = None
  ) {

    require(nullableSetOfNullableTexts ne null, "Null value was provided for property \"nullableSetOfNullableTexts\"")
    if (nullableSetOfNullableTexts.isDefined) require(nullableSetOfNullableTexts.get ne null, "Null value was provided for property \"nullableSetOfNullableTexts\"")
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableTexts)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableTexts") nullableSetOfNullableTexts: Option[Set[Option[String]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableSetOfNullableTexts") calculatedNullableSetOfNullableTexts: Option[Set[Option[String]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableSetOfNullableTexts") persistedNullableSetOfNullableTexts: Option[Set[Option[String]]]
  ) =
    this( nullableSetOfNullableTexts = nullableSetOfNullableTexts, calculatedNullableSetOfNullableTexts = calculatedNullableSetOfNullableTexts, persistedNullableSetOfNullableTexts = persistedNullableSetOfNullableTexts)

}