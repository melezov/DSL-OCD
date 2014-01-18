package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneListOfOneIps_4 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _oneListOfOneIps: IndexedSeq[java.net.InetAddress],
    private var _calculatedOneListOfOneIps: IndexedSeq[java.net.InetAddress],
    private var _persistedOneListOfOneIps: IndexedSeq[java.net.InetAddress]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneListOfOneIps_4 => c.URI == URI
    case _ => false
  }

  override def toString = "OneListOfOneIps_4("+ URI +")"

   def copy(oneListOfOneIps: IndexedSeq[java.net.InetAddress] = this._oneListOfOneIps): OneListOfOneIps_4 = {

  require(oneListOfOneIps ne null, "Null value was provided for property \"oneListOfOneIps\"")
  com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneIps)
    new OneListOfOneIps_4(_URI = this.URI, __locator = this.__locator, _ID = _ID, _oneListOfOneIps = oneListOfOneIps, _calculatedOneListOfOneIps = _calculatedOneListOfOneIps, _persistedOneListOfOneIps = _persistedOneListOfOneIps)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneIps_4): this.type = {
    this._URI = result._URI
    this._oneListOfOneIps = result._oneListOfOneIps
    this._calculatedOneListOfOneIps = result._calculatedOneListOfOneIps
    this._persistedOneListOfOneIps = result._persistedOneListOfOneIps
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.OneListOfOneIps_4](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneIps")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneListOfOneIps = {
    _oneListOfOneIps
  }

  def oneListOfOneIps_= (value: IndexedSeq[java.net.InetAddress]) {
    com.dslplatform.api.Guards.checkCollectionNulls(value)
    _oneListOfOneIps = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneIps")
  def calculatedOneListOfOneIps = {
    _calculatedOneListOfOneIps
  }

  def calculatedOneListOfOneIps_= (value: IndexedSeq[java.net.InetAddress]) {
    _calculatedOneListOfOneIps = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneIps")
  def persistedOneListOfOneIps = {
    _persistedOneListOfOneIps
  }

  def persistedOneListOfOneIps_= (value: IndexedSeq[java.net.InetAddress]) {
    _persistedOneListOfOneIps = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("oneListOfOneIps") oneListOfOneIps: IndexedSeq[java.net.InetAddress]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedOneListOfOneIps") calculatedOneListOfOneIps: IndexedSeq[java.net.InetAddress]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedOneListOfOneIps") persistedOneListOfOneIps: IndexedSeq[java.net.InetAddress]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _oneListOfOneIps = if (oneListOfOneIps == null) IndexedSeq.empty else oneListOfOneIps, _calculatedOneListOfOneIps = calculatedOneListOfOneIps, _persistedOneListOfOneIps = persistedOneListOfOneIps)

}

object OneListOfOneIps_4 extends AggregateRootCompanion[OneListOfOneIps_4]{

  def apply(
    oneListOfOneIps: IndexedSeq[java.net.InetAddress] = IndexedSeq.empty
  ) = {
    com.dslplatform.api.Guards.checkCollectionNulls(oneListOfOneIps)
    require(oneListOfOneIps ne null, "Null value was provided for property \"oneListOfOneIps\"")
    new OneListOfOneIps_4(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _oneListOfOneIps = oneListOfOneIps
    , _calculatedOneListOfOneIps = IndexedSeq.empty
    , _persistedOneListOfOneIps = IndexedSeq.empty)
  }

}
