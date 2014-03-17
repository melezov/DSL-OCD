package com.dslplatform.ocd.values.PropertyInValue

case class OneText_1 @com.fasterxml.jackson.annotation.JsonIgnore() (
     oneText: String = ""
  ) {

    require(oneText ne null, "Null value was provided for property \"oneText\"")

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("oneText") oneText: String
  ) =
    this( oneText = if (oneText == null) "" else oneText)

}