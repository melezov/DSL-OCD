package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup

import com.dslplatform.api.patterns._

case class OneSetOfNullableUrls_6Grid @com.fasterxml.jackson.annotation.JsonIgnore() (
    URI: String,
     oneSetOfNullableUrls: Set[Option[java.net.URI]]
  ) extends Identifiable {

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("oneSetOfNullableUrls") oneSetOfNullableUrls: Set[Option[java.net.URI]]
  ) =
    this(URI = URI, oneSetOfNullableUrls = if (oneSetOfNullableUrls == null) Set.empty else oneSetOfNullableUrls)

}

object OneSetOfNullableUrls_6Grid
