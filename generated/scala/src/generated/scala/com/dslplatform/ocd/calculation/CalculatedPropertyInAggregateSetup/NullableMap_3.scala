package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableMap_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableMap: Option[Map[String, String]],
    private var _calculatedNullableMap: Option[Map[String, String]],
    private var _persistedNullableMap: Option[Map[String, String]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableMap_3 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableMap_3("+ URI +")"

   def copy(nullableMap: Option[Map[String, String]] = this._nullableMap): NullableMap_3 = {

  require(nullableMap ne null, "Null value was provided for property \"nullableMap\"")
  if(nullableMap.isDefined) require(nullableMap.get ne null, "Null value was provided for property \"nullableMap\"")
    new NullableMap_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableMap = nullableMap, _calculatedNullableMap = _calculatedNullableMap, _persistedNullableMap = _persistedNullableMap)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("ID")
  def ID = {
    _ID
  }

  private def ID_= (value: Int) {
    _ID = value

  }

  @com.fasterxml.jackson.annotation.JsonIgnore
  def isNewAggregate() = __locator == None

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableMap_3): this.type = {
    this._URI = result._URI
    this._nullableMap = result._nullableMap
    this._calculatedNullableMap = result._calculatedNullableMap
    this._persistedNullableMap = result._persistedNullableMap
    this._ID = result._ID
    this
  }

  def create()(implicit locator: ServiceLocator, ec: ExecutionContext, duration: Duration): this.type = {
    __locator = Some(Option(locator).getOrElse(Bootstrap.getLocator))
    val toUpdateWith = Await.result(__locator.get.resolve(classOf[CrudProxy]).create(this), duration)
    updateWithAnother(toUpdateWith)

  }

  def update()(implicit ec: ExecutionContext, duration: Duration): this.type = {
    val toUpdateWith = Await.result(__locator.get.resolve(classOf[CrudProxy]).update(this), duration)
    updateWithAnother(toUpdateWith)

  }

  def delete()(implicit ec: ExecutionContext, duration: Duration) = {
    if (__locator.isEmpty) throw new IllegalArgumentException("Can't delete aggregate before it's saved")
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableMap_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableMap")
  def nullableMap = {
    _nullableMap
  }

  def nullableMap_= (value: Option[Map[String, String]]) {
    _nullableMap = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableMap")
  def calculatedNullableMap = {
    _calculatedNullableMap
  }

  def calculatedNullableMap_= (value: Option[Map[String, String]]) {
    _calculatedNullableMap = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableMap")
  def persistedNullableMap = {
    _persistedNullableMap
  }

  def persistedNullableMap_= (value: Option[Map[String, String]]) {
    _persistedNullableMap = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableMap") nullableMap: Option[Map[String, String]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableMap") calculatedNullableMap: Option[Map[String, String]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableMap") persistedNullableMap: Option[Map[String, String]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableMap = nullableMap, _calculatedNullableMap = calculatedNullableMap, _persistedNullableMap = persistedNullableMap)

}

object NullableMap_3 extends AggregateRootCompanion[NullableMap_3]{

  def apply(
    nullableMap: Option[Map[String, String]] = None
  ) = {
    require(nullableMap ne null, "Null value was provided for property \"nullableMap\"")
    if (nullableMap.isDefined) require(nullableMap.get ne null, "Null value was provided for property \"nullableMap\"")
    new NullableMap_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableMap = nullableMap
    , _calculatedNullableMap = None
    , _persistedNullableMap = None)
  }

}
