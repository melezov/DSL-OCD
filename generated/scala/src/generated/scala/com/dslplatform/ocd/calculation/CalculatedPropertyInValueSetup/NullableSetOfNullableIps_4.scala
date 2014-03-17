package com.dslplatform.ocd.calculation.CalculatedPropertyInValueSetup

case class NullableSetOfNullableIps_4 @com.fasterxml.jackson.annotation.JsonIgnore() (
     nullableSetOfNullableIps: Option[Set[Option[java.net.InetAddress]]] = None,
     calculatedNullableSetOfNullableIps: Option[Set[Option[java.net.InetAddress]]] = None,
     persistedNullableSetOfNullableIps: Option[Set[Option[java.net.InetAddress]]] = None
  ) {

    require(nullableSetOfNullableIps ne null, "Null value was provided for property \"nullableSetOfNullableIps\"")
    if (nullableSetOfNullableIps.isDefined) require(nullableSetOfNullableIps.get ne null, "Null value was provided for property \"nullableSetOfNullableIps\"")
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableIps)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableIps") nullableSetOfNullableIps: Option[Set[Option[java.net.InetAddress]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableSetOfNullableIps") calculatedNullableSetOfNullableIps: Option[Set[Option[java.net.InetAddress]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableSetOfNullableIps") persistedNullableSetOfNullableIps: Option[Set[Option[java.net.InetAddress]]]
  ) =
    this( nullableSetOfNullableIps = nullableSetOfNullableIps, calculatedNullableSetOfNullableIps = calculatedNullableSetOfNullableIps, persistedNullableSetOfNullableIps = persistedNullableSetOfNullableIps)

}