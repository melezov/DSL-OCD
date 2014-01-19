package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup

case class NullableSetOfNullableTimestamps_4 @com.fasterxml.jackson.annotation.JsonIgnore() (
     nullableSetOfNullableTimestamps: Option[Set[Option[org.joda.time.DateTime]]] = None,
     calculatedNullableSetOfNullableTimestamps: Option[Set[Option[org.joda.time.DateTime]]] = None,
     persistedNullableSetOfNullableTimestamps: Option[Set[Option[org.joda.time.DateTime]]] = None
  ) {

    require(nullableSetOfNullableTimestamps ne null, "Null value was provided for property \"nullableSetOfNullableTimestamps\"")
    if (nullableSetOfNullableTimestamps.isDefined) require(nullableSetOfNullableTimestamps.get ne null, "Null value was provided for property \"nullableSetOfNullableTimestamps\"")
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableTimestamps)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableTimestamps") nullableSetOfNullableTimestamps: Option[Set[Option[org.joda.time.DateTime]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableSetOfNullableTimestamps") calculatedNullableSetOfNullableTimestamps: Option[Set[Option[org.joda.time.DateTime]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableSetOfNullableTimestamps") persistedNullableSetOfNullableTimestamps: Option[Set[Option[org.joda.time.DateTime]]]
  ) =
    this( nullableSetOfNullableTimestamps = nullableSetOfNullableTimestamps, calculatedNullableSetOfNullableTimestamps = calculatedNullableSetOfNullableTimestamps, persistedNullableSetOfNullableTimestamps = persistedNullableSetOfNullableTimestamps)

}
