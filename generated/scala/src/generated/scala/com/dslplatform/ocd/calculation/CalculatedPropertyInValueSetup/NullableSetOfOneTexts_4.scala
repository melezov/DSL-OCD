package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup

case class NullableSetOfOneTexts_4 @com.fasterxml.jackson.annotation.JsonIgnore() (
     nullableSetOfOneTexts: Option[Set[String]] = None,
     calculatedNullableSetOfOneTexts: Option[Set[String]] = None,
     persistedNullableSetOfOneTexts: Option[Set[String]] = None
  ) {

    require(nullableSetOfOneTexts ne null, "Null value was provided for property \"nullableSetOfOneTexts\"")
    if (nullableSetOfOneTexts.isDefined) require(nullableSetOfOneTexts.get ne null, "Null value was provided for property \"nullableSetOfOneTexts\"")
    com.dslplatform.api.Guards.checkCollectionNulls(nullableSetOfOneTexts)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfOneTexts") nullableSetOfOneTexts: Option[Set[String]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableSetOfOneTexts") calculatedNullableSetOfOneTexts: Option[Set[String]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableSetOfOneTexts") persistedNullableSetOfOneTexts: Option[Set[String]]
  ) =
    this( nullableSetOfOneTexts = nullableSetOfOneTexts, calculatedNullableSetOfOneTexts = calculatedNullableSetOfOneTexts, persistedNullableSetOfOneTexts = persistedNullableSetOfOneTexts)

}