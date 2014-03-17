package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneListOfOneStrings_4 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _oneListOfOneStrings: IndexedSeq[String],
    private var _calculatedOneListOfOneStrings: IndexedSeq[String],
    private var _persistedOneListOfOneStrings: IndexedSeq[String]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneListOfOneStrings_4 => c.URI == URI
    case _ => false
  }

  override def toString = "OneListOfOneStrings_4("+ URI +")"

   def copy(oneListOfOneStrings: IndexedSeq[String] = this._oneListOfOneStrings): OneListOfOneStrings_4 = {

  require(oneListOfOneStrings ne null, "Null value was provided for property \"oneListOfOneStrings\"")
  com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneStrings)
    new OneListOfOneStrings_4(_URI = this.URI, __locator = this.__locator, _ID = _ID, _oneListOfOneStrings = oneListOfOneStrings, _calculatedOneListOfOneStrings = _calculatedOneListOfOneStrings, _persistedOneListOfOneStrings = _persistedOneListOfOneStrings)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneStrings_4): this.type = {
    this._URI = result._URI
    this._oneListOfOneStrings = result._oneListOfOneStrings
    this._calculatedOneListOfOneStrings = result._calculatedOneListOfOneStrings
    this._persistedOneListOfOneStrings = result._persistedOneListOfOneStrings
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneStrings_4](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneStrings")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneListOfOneStrings = {
    _oneListOfOneStrings
  }

  def oneListOfOneStrings_= (value: IndexedSeq[String]) {
    com.dslplatform.api.Guards.checkCollectionNulls(value)
    _oneListOfOneStrings = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneStrings")
  def calculatedOneListOfOneStrings = {
    _calculatedOneListOfOneStrings
  }

  def calculatedOneListOfOneStrings_= (value: IndexedSeq[String]) {
    _calculatedOneListOfOneStrings = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneStrings")
  def persistedOneListOfOneStrings = {
    _persistedOneListOfOneStrings
  }

  def persistedOneListOfOneStrings_= (value: IndexedSeq[String]) {
    _persistedOneListOfOneStrings = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneStrings") oneListOfOneStrings: IndexedSeq[String]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneStrings") calculatedOneListOfOneStrings: IndexedSeq[String]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneStrings") persistedOneListOfOneStrings: IndexedSeq[String]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _oneListOfOneStrings = if (oneListOfOneStrings == null) IndexedSeq.empty else oneListOfOneStrings, _calculatedOneListOfOneStrings = calculatedOneListOfOneStrings, _persistedOneListOfOneStrings = persistedOneListOfOneStrings)

}

object OneListOfOneStrings_4 extends AggregateRootCompanion[OneListOfOneStrings_4]{

  def apply(
    oneListOfOneStrings: IndexedSeq[String] = IndexedSeq.empty
  ) = {
    com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneStrings)
    require(oneListOfOneStrings ne null, "Null value was provided for property \"oneListOfOneStrings\"")
    new OneListOfOneStrings_4(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _oneListOfOneStrings = oneListOfOneStrings
    , _calculatedOneListOfOneStrings = IndexedSeq.empty
    , _persistedOneListOfOneStrings = IndexedSeq.empty)
  }

}