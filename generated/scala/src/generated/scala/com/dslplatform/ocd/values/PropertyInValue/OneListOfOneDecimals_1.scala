package com.dslplatform.ocd.values.PropertyInValue

case class OneListOfOneDecimals_1 @com.fasterxml.jackson.annotation.JsonIgnore() (
     oneListOfOneDecimals: IndexedSeq[BigDecimal] = IndexedSeq.empty
  ) {

    require(oneListOfOneDecimals ne null, "Null value was provided for property \"oneListOfOneDecimals\"")
    com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneDecimals)

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: com.dslplatform.api.patterns.ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneDecimals") oneListOfOneDecimals: IndexedSeq[BigDecimal]
  ) =
    this( oneListOfOneDecimals = if (oneListOfOneDecimals == null) IndexedSeq.empty else oneListOfOneDecimals)

}