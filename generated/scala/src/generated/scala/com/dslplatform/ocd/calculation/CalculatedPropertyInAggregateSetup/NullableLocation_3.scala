package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableLocation_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableLocation: Option[java.awt.geom.Point2D],
    private var _calculatedNullableLocation: Option[java.awt.geom.Point2D],
    private var _persistedNullableLocation: Option[java.awt.geom.Point2D]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableLocation_3 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableLocation_3("+ URI +")"

   def copy(nullableLocation: Option[java.awt.geom.Point2D] = this._nullableLocation): NullableLocation_3 = {

  require(nullableLocation ne null, "Null value was provided for property \"nullableLocation\"")
  if(nullableLocation.isDefined) require(nullableLocation.get ne null, "Null value was provided for property \"nullableLocation\"")
    new NullableLocation_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableLocation = nullableLocation, _calculatedNullableLocation = _calculatedNullableLocation, _persistedNullableLocation = _persistedNullableLocation)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableLocation_3): this.type = {
    this._URI = result._URI
    this._nullableLocation = result._nullableLocation
    this._calculatedNullableLocation = result._calculatedNullableLocation
    this._persistedNullableLocation = result._persistedNullableLocation
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableLocation_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableLocation")
  def nullableLocation = {
    _nullableLocation
  }

  def nullableLocation_= (value: Option[java.awt.geom.Point2D]) {
    _nullableLocation = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableLocation")
  def calculatedNullableLocation = {
    _calculatedNullableLocation
  }

  def calculatedNullableLocation_= (value: Option[java.awt.geom.Point2D]) {
    _calculatedNullableLocation = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableLocation")
  def persistedNullableLocation = {
    _persistedNullableLocation
  }

  def persistedNullableLocation_= (value: Option[java.awt.geom.Point2D]) {
    _persistedNullableLocation = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableLocation") nullableLocation: Option[java.awt.geom.Point2D]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableLocation") calculatedNullableLocation: Option[java.awt.geom.Point2D]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableLocation") persistedNullableLocation: Option[java.awt.geom.Point2D]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableLocation = nullableLocation, _calculatedNullableLocation = calculatedNullableLocation, _persistedNullableLocation = persistedNullableLocation)

}

object NullableLocation_3 extends AggregateRootCompanion[NullableLocation_3]{

  def apply(
    nullableLocation: Option[java.awt.geom.Point2D] = None
  ) = {
    require(nullableLocation ne null, "Null value was provided for property \"nullableLocation\"")
    if (nullableLocation.isDefined) require(nullableLocation.get ne null, "Null value was provided for property \"nullableLocation\"")
    new NullableLocation_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableLocation = nullableLocation
    , _calculatedNullableLocation = None
    , _persistedNullableLocation = None)
  }

}
