package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneListOfOneMaps_4 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _oneListOfOneMaps: IndexedSeq[Map[String, String]],
    private var _calculatedOneListOfOneMaps: IndexedSeq[Map[String, String]],
    private var _persistedOneListOfOneMaps: IndexedSeq[Map[String, String]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneListOfOneMaps_4 => c.URI == URI
    case _ => false
  }

  override def toString = "OneListOfOneMaps_4("+ URI +")"

   def copy(oneListOfOneMaps: IndexedSeq[Map[String, String]] = this._oneListOfOneMaps): OneListOfOneMaps_4 = {

  require(oneListOfOneMaps ne null, "Null value was provided for property \"oneListOfOneMaps\"")
  com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneMaps)
    new OneListOfOneMaps_4(_URI = this.URI, __locator = this.__locator, _ID = _ID, _oneListOfOneMaps = oneListOfOneMaps, _calculatedOneListOfOneMaps = _calculatedOneListOfOneMaps, _persistedOneListOfOneMaps = _persistedOneListOfOneMaps)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneMaps_4): this.type = {
    this._URI = result._URI
    this._oneListOfOneMaps = result._oneListOfOneMaps
    this._calculatedOneListOfOneMaps = result._calculatedOneListOfOneMaps
    this._persistedOneListOfOneMaps = result._persistedOneListOfOneMaps
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneMaps_4](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneMaps")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneListOfOneMaps = {
    _oneListOfOneMaps
  }

  def oneListOfOneMaps_= (value: IndexedSeq[Map[String, String]]) {
    com.dslplatform.api.Guards.checkCollectionNulls(value)
    _oneListOfOneMaps = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneMaps")
  def calculatedOneListOfOneMaps = {
    _calculatedOneListOfOneMaps
  }

  def calculatedOneListOfOneMaps_= (value: IndexedSeq[Map[String, String]]) {
    _calculatedOneListOfOneMaps = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneMaps")
  def persistedOneListOfOneMaps = {
    _persistedOneListOfOneMaps
  }

  def persistedOneListOfOneMaps_= (value: IndexedSeq[Map[String, String]]) {
    _persistedOneListOfOneMaps = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneMaps") oneListOfOneMaps: IndexedSeq[Map[String, String]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneMaps") calculatedOneListOfOneMaps: IndexedSeq[Map[String, String]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneMaps") persistedOneListOfOneMaps: IndexedSeq[Map[String, String]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _oneListOfOneMaps = if (oneListOfOneMaps == null) IndexedSeq.empty else oneListOfOneMaps, _calculatedOneListOfOneMaps = calculatedOneListOfOneMaps, _persistedOneListOfOneMaps = persistedOneListOfOneMaps)

}

object OneListOfOneMaps_4 extends AggregateRootCompanion[OneListOfOneMaps_4]{

  def apply(
    oneListOfOneMaps: IndexedSeq[Map[String, String]] = IndexedSeq.empty
  ) = {
    com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneMaps)
    require(oneListOfOneMaps ne null, "Null value was provided for property \"oneListOfOneMaps\"")
    new OneListOfOneMaps_4(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _oneListOfOneMaps = oneListOfOneMaps
    , _calculatedOneListOfOneMaps = IndexedSeq.empty
    , _persistedOneListOfOneMaps = IndexedSeq.empty)
  }

}