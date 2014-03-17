package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneListOfOneDecimalsWithScaleOf9_4 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _oneListOfOneDecimalsWithScaleOf9: IndexedSeq[BigDecimal],
    private var _calculatedOneListOfOneDecimalsWithScaleOf9: IndexedSeq[BigDecimal],
    private var _persistedOneListOfOneDecimalsWithScaleOf9: IndexedSeq[BigDecimal]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneListOfOneDecimalsWithScaleOf9_4 => c.URI == URI
    case _ => false
  }

  override def toString = "OneListOfOneDecimalsWithScaleOf9_4("+ URI +")"

   def copy(oneListOfOneDecimalsWithScaleOf9: IndexedSeq[BigDecimal] = this._oneListOfOneDecimalsWithScaleOf9): OneListOfOneDecimalsWithScaleOf9_4 = {

  require(oneListOfOneDecimalsWithScaleOf9 ne null, "Null value was provided for property \"oneListOfOneDecimalsWithScaleOf9\"")
  com.dslplatform.api.Guards.checkCollectionScale(oneListOfOneDecimalsWithScaleOf9, 9)
  com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneDecimalsWithScaleOf9)
    new OneListOfOneDecimalsWithScaleOf9_4(_URI = this.URI, __locator = this.__locator, _ID = _ID, _oneListOfOneDecimalsWithScaleOf9 = oneListOfOneDecimalsWithScaleOf9, _calculatedOneListOfOneDecimalsWithScaleOf9 = _calculatedOneListOfOneDecimalsWithScaleOf9, _persistedOneListOfOneDecimalsWithScaleOf9 = _persistedOneListOfOneDecimalsWithScaleOf9)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneDecimalsWithScaleOf9_4): this.type = {
    this._URI = result._URI
    this._oneListOfOneDecimalsWithScaleOf9 = result._oneListOfOneDecimalsWithScaleOf9
    this._calculatedOneListOfOneDecimalsWithScaleOf9 = result._calculatedOneListOfOneDecimalsWithScaleOf9
    this._persistedOneListOfOneDecimalsWithScaleOf9 = result._persistedOneListOfOneDecimalsWithScaleOf9
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneDecimalsWithScaleOf9_4](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneDecimalsWithScaleOf9")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneListOfOneDecimalsWithScaleOf9 = {
    _oneListOfOneDecimalsWithScaleOf9
  }

  def oneListOfOneDecimalsWithScaleOf9_= (value: IndexedSeq[BigDecimal]) {
    com.dslplatform.api.Guards.checkCollectionScale(value, 9)
    com.dslplatform.api.Guards.checkCollectionNulls(value)
    _oneListOfOneDecimalsWithScaleOf9 = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneDecimalsWithScaleOf9")
  def calculatedOneListOfOneDecimalsWithScaleOf9 = {
    _calculatedOneListOfOneDecimalsWithScaleOf9
  }

  def calculatedOneListOfOneDecimalsWithScaleOf9_= (value: IndexedSeq[BigDecimal]) {
    _calculatedOneListOfOneDecimalsWithScaleOf9 = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneDecimalsWithScaleOf9")
  def persistedOneListOfOneDecimalsWithScaleOf9 = {
    _persistedOneListOfOneDecimalsWithScaleOf9
  }

  def persistedOneListOfOneDecimalsWithScaleOf9_= (value: IndexedSeq[BigDecimal]) {
    _persistedOneListOfOneDecimalsWithScaleOf9 = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneDecimalsWithScaleOf9") oneListOfOneDecimalsWithScaleOf9: IndexedSeq[BigDecimal]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneDecimalsWithScaleOf9") calculatedOneListOfOneDecimalsWithScaleOf9: IndexedSeq[BigDecimal]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneDecimalsWithScaleOf9") persistedOneListOfOneDecimalsWithScaleOf9: IndexedSeq[BigDecimal]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _oneListOfOneDecimalsWithScaleOf9 = if (oneListOfOneDecimalsWithScaleOf9 == null) IndexedSeq.empty else oneListOfOneDecimalsWithScaleOf9, _calculatedOneListOfOneDecimalsWithScaleOf9 = calculatedOneListOfOneDecimalsWithScaleOf9, _persistedOneListOfOneDecimalsWithScaleOf9 = persistedOneListOfOneDecimalsWithScaleOf9)

}

object OneListOfOneDecimalsWithScaleOf9_4 extends AggregateRootCompanion[OneListOfOneDecimalsWithScaleOf9_4]{

  def apply(
    oneListOfOneDecimalsWithScaleOf9: IndexedSeq[BigDecimal] = IndexedSeq.empty
  ) = {
    com.dslplatform.api.Guards.checkCollectionScale(oneListOfOneDecimalsWithScaleOf9, 9)
    com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneDecimalsWithScaleOf9)
    require(oneListOfOneDecimalsWithScaleOf9 ne null, "Null value was provided for property \"oneListOfOneDecimalsWithScaleOf9\"")
    new OneListOfOneDecimalsWithScaleOf9_4(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _oneListOfOneDecimalsWithScaleOf9 = oneListOfOneDecimalsWithScaleOf9
    , _calculatedOneListOfOneDecimalsWithScaleOf9 = IndexedSeq.empty
    , _persistedOneListOfOneDecimalsWithScaleOf9 = IndexedSeq.empty)
  }

}