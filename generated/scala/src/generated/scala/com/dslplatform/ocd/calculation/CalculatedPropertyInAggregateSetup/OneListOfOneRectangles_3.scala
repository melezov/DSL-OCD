package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneListOfOneRectangles_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _oneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D],
    private var _calculatedOneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D],
    private var _persistedOneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneListOfOneRectangles_3 => c.URI == URI
    case _ => false
  }

  override def toString = "OneListOfOneRectangles_3("+ URI +")"

   def copy(oneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D] = this._oneListOfOneRectangles): OneListOfOneRectangles_3 = {

  require(oneListOfOneRectangles ne null, "Null value was provided for property \"oneListOfOneRectangles\"")
  com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneRectangles)
    new OneListOfOneRectangles_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _oneListOfOneRectangles = oneListOfOneRectangles, _calculatedOneListOfOneRectangles = _calculatedOneListOfOneRectangles, _persistedOneListOfOneRectangles = _persistedOneListOfOneRectangles)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneRectangles_3): this.type = {
    this._URI = result._URI
    this._oneListOfOneRectangles = result._oneListOfOneRectangles
    this._calculatedOneListOfOneRectangles = result._calculatedOneListOfOneRectangles
    this._persistedOneListOfOneRectangles = result._persistedOneListOfOneRectangles
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneRectangles_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneRectangles")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneListOfOneRectangles = {
    _oneListOfOneRectangles
  }

  def oneListOfOneRectangles_= (value: IndexedSeq[java.awt.geom.Rectangle2D]) {
    com.dslplatform.api.Guards.checkCollectionNulls(value)
    _oneListOfOneRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneRectangles")
  def calculatedOneListOfOneRectangles = {
    _calculatedOneListOfOneRectangles
  }

  def calculatedOneListOfOneRectangles_= (value: IndexedSeq[java.awt.geom.Rectangle2D]) {
    _calculatedOneListOfOneRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneRectangles")
  def persistedOneListOfOneRectangles = {
    _persistedOneListOfOneRectangles
  }

  def persistedOneListOfOneRectangles_= (value: IndexedSeq[java.awt.geom.Rectangle2D]) {
    _persistedOneListOfOneRectangles = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneRectangles") oneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneRectangles") calculatedOneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneRectangles") persistedOneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _oneListOfOneRectangles = if (oneListOfOneRectangles == null) IndexedSeq.empty else oneListOfOneRectangles, _calculatedOneListOfOneRectangles = calculatedOneListOfOneRectangles, _persistedOneListOfOneRectangles = persistedOneListOfOneRectangles)

}

object OneListOfOneRectangles_3 extends AggregateRootCompanion[OneListOfOneRectangles_3]{

  def apply(
    oneListOfOneRectangles: IndexedSeq[java.awt.geom.Rectangle2D] = IndexedSeq.empty
  ) = {
    com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneRectangles)
    require(oneListOfOneRectangles ne null, "Null value was provided for property \"oneListOfOneRectangles\"")
    new OneListOfOneRectangles_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _oneListOfOneRectangles = oneListOfOneRectangles
    , _calculatedOneListOfOneRectangles = IndexedSeq.empty
    , _persistedOneListOfOneRectangles = IndexedSeq.empty)
  }

}