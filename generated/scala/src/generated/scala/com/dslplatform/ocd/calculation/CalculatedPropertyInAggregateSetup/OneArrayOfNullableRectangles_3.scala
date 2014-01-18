package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneArrayOfNullableRectangles_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _oneArrayOfNullableRectangles: Array[Option[java.awt.geom.Rectangle2D]],
    private var _calculatedOneArrayOfNullableRectangles: Array[Option[java.awt.geom.Rectangle2D]],
    private var _persistedOneArrayOfNullableRectangles: Array[Option[java.awt.geom.Rectangle2D]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneArrayOfNullableRectangles_3 => c.URI == URI
    case _ => false
  }

  override def toString = "OneArrayOfNullableRectangles_3("+ URI +")"

   def copy(oneArrayOfNullableRectangles: Array[Option[java.awt.geom.Rectangle2D]] = this._oneArrayOfNullableRectangles): OneArrayOfNullableRectangles_3 = {

  require(oneArrayOfNullableRectangles ne null, "Null value was provided for property \"oneArrayOfNullableRectangles\"")
  com.dslplatform.api.Guards.checkArrayOptionRefNulls(oneArrayOfNullableRectangles)
    new OneArrayOfNullableRectangles_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _oneArrayOfNullableRectangles = oneArrayOfNullableRectangles, _calculatedOneArrayOfNullableRectangles = _calculatedOneArrayOfNullableRectangles, _persistedOneArrayOfNullableRectangles = _persistedOneArrayOfNullableRectangles)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneArrayOfNullableRectangles_3): this.type = {
    this._URI = result._URI
    this._oneArrayOfNullableRectangles = result._oneArrayOfNullableRectangles
    this._calculatedOneArrayOfNullableRectangles = result._calculatedOneArrayOfNullableRectangles
    this._persistedOneArrayOfNullableRectangles = result._persistedOneArrayOfNullableRectangles
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneArrayOfNullableRectangles_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneArrayOfNullableRectangles")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneArrayOfNullableRectangles = {
    _oneArrayOfNullableRectangles
  }

  def oneArrayOfNullableRectangles_= (value: Array[Option[java.awt.geom.Rectangle2D]]) {
    com.dslplatform.api.Guards.checkArrayOptionRefNulls(value)
    _oneArrayOfNullableRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneArrayOfNullableRectangles")
  def calculatedOneArrayOfNullableRectangles = {
    _calculatedOneArrayOfNullableRectangles
  }

  def calculatedOneArrayOfNullableRectangles_= (value: Array[Option[java.awt.geom.Rectangle2D]]) {
    _calculatedOneArrayOfNullableRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedOneArrayOfNullableRectangles")
  def persistedOneArrayOfNullableRectangles = {
    _persistedOneArrayOfNullableRectangles
  }

  def persistedOneArrayOfNullableRectangles_= (value: Array[Option[java.awt.geom.Rectangle2D]]) {
    _persistedOneArrayOfNullableRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("oneArrayOfNullableRectangles") oneArrayOfNullableRectangles: Array[Option[java.awt.geom.Rectangle2D]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneArrayOfNullableRectangles") calculatedOneArrayOfNullableRectangles: Array[Option[java.awt.geom.Rectangle2D]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedOneArrayOfNullableRectangles") persistedOneArrayOfNullableRectangles: Array[Option[java.awt.geom.Rectangle2D]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _oneArrayOfNullableRectangles = if (oneArrayOfNullableRectangles == null) Array.empty else oneArrayOfNullableRectangles, _calculatedOneArrayOfNullableRectangles = calculatedOneArrayOfNullableRectangles, _persistedOneArrayOfNullableRectangles = persistedOneArrayOfNullableRectangles)

}

object OneArrayOfNullableRectangles_3 extends AggregateRootCompanion[OneArrayOfNullableRectangles_3]{

  def apply(
    oneArrayOfNullableRectangles: Array[Option[java.awt.geom.Rectangle2D]] = Array.empty
  ) = {
    com.dslplatform.api.Guards.checkArrayOptionRefNulls(oneArrayOfNullableRectangles)
    require(oneArrayOfNullableRectangles ne null, "Null value was provided for property \"oneArrayOfNullableRectangles\"")
    new OneArrayOfNullableRectangles_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _oneArrayOfNullableRectangles = oneArrayOfNullableRectangles
    , _calculatedOneArrayOfNullableRectangles = Array.empty
    , _persistedOneArrayOfNullableRectangles = Array.empty)
  }

}
