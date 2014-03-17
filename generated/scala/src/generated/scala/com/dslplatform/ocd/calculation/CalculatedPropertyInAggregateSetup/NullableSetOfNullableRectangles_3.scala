package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableSetOfNullableRectangles_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableSetOfNullableRectangles: Option[Set[Option[java.awt.geom.Rectangle2D]]],
    private var _calculatedNullableSetOfNullableRectangles: Option[Set[Option[java.awt.geom.Rectangle2D]]],
    private var _persistedNullableSetOfNullableRectangles: Option[Set[Option[java.awt.geom.Rectangle2D]]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableSetOfNullableRectangles_3 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableSetOfNullableRectangles_3("+ URI +")"

   def copy(nullableSetOfNullableRectangles: Option[Set[Option[java.awt.geom.Rectangle2D]]] = this._nullableSetOfNullableRectangles): NullableSetOfNullableRectangles_3 = {

  require(nullableSetOfNullableRectangles ne null, "Null value was provided for property \"nullableSetOfNullableRectangles\"")
  if(nullableSetOfNullableRectangles.isDefined) require(nullableSetOfNullableRectangles.get ne null, "Null value was provided for property \"nullableSetOfNullableRectangles\"")
  com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableRectangles)
    new NullableSetOfNullableRectangles_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableSetOfNullableRectangles = nullableSetOfNullableRectangles, _calculatedNullableSetOfNullableRectangles = _calculatedNullableSetOfNullableRectangles, _persistedNullableSetOfNullableRectangles = _persistedNullableSetOfNullableRectangles)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfNullableRectangles_3): this.type = {
    this._URI = result._URI
    this._nullableSetOfNullableRectangles = result._nullableSetOfNullableRectangles
    this._calculatedNullableSetOfNullableRectangles = result._calculatedNullableSetOfNullableRectangles
    this._persistedNullableSetOfNullableRectangles = result._persistedNullableSetOfNullableRectangles
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfNullableRectangles_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableRectangles")
  def nullableSetOfNullableRectangles = {
    _nullableSetOfNullableRectangles
  }

  def nullableSetOfNullableRectangles_= (value: Option[Set[Option[java.awt.geom.Rectangle2D]]]) {
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(value)
    _nullableSetOfNullableRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableSetOfNullableRectangles")
  def calculatedNullableSetOfNullableRectangles = {
    _calculatedNullableSetOfNullableRectangles
  }

  def calculatedNullableSetOfNullableRectangles_= (value: Option[Set[Option[java.awt.geom.Rectangle2D]]]) {
    _calculatedNullableSetOfNullableRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableSetOfNullableRectangles")
  def persistedNullableSetOfNullableRectangles = {
    _persistedNullableSetOfNullableRectangles
  }

  def persistedNullableSetOfNullableRectangles_= (value: Option[Set[Option[java.awt.geom.Rectangle2D]]]) {
    _persistedNullableSetOfNullableRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableRectangles") nullableSetOfNullableRectangles: Option[Set[Option[java.awt.geom.Rectangle2D]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableSetOfNullableRectangles") calculatedNullableSetOfNullableRectangles: Option[Set[Option[java.awt.geom.Rectangle2D]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableSetOfNullableRectangles") persistedNullableSetOfNullableRectangles: Option[Set[Option[java.awt.geom.Rectangle2D]]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableSetOfNullableRectangles = nullableSetOfNullableRectangles, _calculatedNullableSetOfNullableRectangles = calculatedNullableSetOfNullableRectangles, _persistedNullableSetOfNullableRectangles = persistedNullableSetOfNullableRectangles)

}

object NullableSetOfNullableRectangles_3 extends AggregateRootCompanion[NullableSetOfNullableRectangles_3]{

  def apply(
    nullableSetOfNullableRectangles: Option[Set[Option[java.awt.geom.Rectangle2D]]] = None
  ) = {
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableRectangles)
    require(nullableSetOfNullableRectangles ne null, "Null value was provided for property \"nullableSetOfNullableRectangles\"")
    if (nullableSetOfNullableRectangles.isDefined) require(nullableSetOfNullableRectangles.get ne null, "Null value was provided for property \"nullableSetOfNullableRectangles\"")
    new NullableSetOfNullableRectangles_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableSetOfNullableRectangles = nullableSetOfNullableRectangles
    , _calculatedNullableSetOfNullableRectangles = None
    , _persistedNullableSetOfNullableRectangles = None)
  }

}