package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableListOfOneDoubles_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableListOfOneDoubles: Option[IndexedSeq[Double]],
    private var _calculatedNullableListOfOneDoubles: Option[IndexedSeq[Double]],
    private var _persistedNullableListOfOneDoubles: Option[IndexedSeq[Double]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableListOfOneDoubles_3 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableListOfOneDoubles_3("+ URI +")"

   def copy(nullableListOfOneDoubles: Option[IndexedSeq[Double]] = this._nullableListOfOneDoubles): NullableListOfOneDoubles_3 = {

  require(nullableListOfOneDoubles ne null, "Null value was provided for property \"nullableListOfOneDoubles\"")
  if(nullableListOfOneDoubles.isDefined) require(nullableListOfOneDoubles.get ne null, "Null value was provided for property \"nullableListOfOneDoubles\"")
    new NullableListOfOneDoubles_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableListOfOneDoubles = nullableListOfOneDoubles, _calculatedNullableListOfOneDoubles = _calculatedNullableListOfOneDoubles, _persistedNullableListOfOneDoubles = _persistedNullableListOfOneDoubles)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableListOfOneDoubles_3): this.type = {
    this._URI = result._URI
    this._nullableListOfOneDoubles = result._nullableListOfOneDoubles
    this._calculatedNullableListOfOneDoubles = result._calculatedNullableListOfOneDoubles
    this._persistedNullableListOfOneDoubles = result._persistedNullableListOfOneDoubles
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableListOfOneDoubles_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableListOfOneDoubles")
  def nullableListOfOneDoubles = {
    _nullableListOfOneDoubles
  }

  def nullableListOfOneDoubles_= (value: Option[IndexedSeq[Double]]) {
    _nullableListOfOneDoubles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableListOfOneDoubles")
  def calculatedNullableListOfOneDoubles = {
    _calculatedNullableListOfOneDoubles
  }

  def calculatedNullableListOfOneDoubles_= (value: Option[IndexedSeq[Double]]) {
    _calculatedNullableListOfOneDoubles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableListOfOneDoubles")
  def persistedNullableListOfOneDoubles = {
    _persistedNullableListOfOneDoubles
  }

  def persistedNullableListOfOneDoubles_= (value: Option[IndexedSeq[Double]]) {
    _persistedNullableListOfOneDoubles = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableListOfOneDoubles") nullableListOfOneDoubles: Option[IndexedSeq[Double]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableListOfOneDoubles") calculatedNullableListOfOneDoubles: Option[IndexedSeq[Double]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableListOfOneDoubles") persistedNullableListOfOneDoubles: Option[IndexedSeq[Double]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableListOfOneDoubles = nullableListOfOneDoubles, _calculatedNullableListOfOneDoubles = calculatedNullableListOfOneDoubles, _persistedNullableListOfOneDoubles = persistedNullableListOfOneDoubles)

}

object NullableListOfOneDoubles_3 extends AggregateRootCompanion[NullableListOfOneDoubles_3]{

  def apply(
    nullableListOfOneDoubles: Option[IndexedSeq[Double]] = None
  ) = {
    require(nullableListOfOneDoubles ne null, "Null value was provided for property \"nullableListOfOneDoubles\"")
    if (nullableListOfOneDoubles.isDefined) require(nullableListOfOneDoubles.get ne null, "Null value was provided for property \"nullableListOfOneDoubles\"")
    new NullableListOfOneDoubles_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableListOfOneDoubles = nullableListOfOneDoubles
    , _calculatedNullableListOfOneDoubles = None
    , _persistedNullableListOfOneDoubles = None)
  }

}
