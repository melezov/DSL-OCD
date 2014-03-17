package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableArrayOfOneDoubles_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableArrayOfOneDoubles: Option[Array[Double]],
    private var _calculatedNullableArrayOfOneDoubles: Option[Array[Double]],
    private var _persistedNullableArrayOfOneDoubles: Option[Array[Double]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableArrayOfOneDoubles_3 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableArrayOfOneDoubles_3("+ URI +")"

   def copy(nullableArrayOfOneDoubles: Option[Array[Double]] = this._nullableArrayOfOneDoubles): NullableArrayOfOneDoubles_3 = {

  require(nullableArrayOfOneDoubles ne null, "Null value was provided for property \"nullableArrayOfOneDoubles\"")
  if(nullableArrayOfOneDoubles.isDefined) require(nullableArrayOfOneDoubles.get ne null, "Null value was provided for property \"nullableArrayOfOneDoubles\"")
    new NullableArrayOfOneDoubles_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableArrayOfOneDoubles = nullableArrayOfOneDoubles, _calculatedNullableArrayOfOneDoubles = _calculatedNullableArrayOfOneDoubles, _persistedNullableArrayOfOneDoubles = _persistedNullableArrayOfOneDoubles)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableArrayOfOneDoubles_3): this.type = {
    this._URI = result._URI
    this._nullableArrayOfOneDoubles = result._nullableArrayOfOneDoubles
    this._calculatedNullableArrayOfOneDoubles = result._calculatedNullableArrayOfOneDoubles
    this._persistedNullableArrayOfOneDoubles = result._persistedNullableArrayOfOneDoubles
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableArrayOfOneDoubles_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableArrayOfOneDoubles")
  def nullableArrayOfOneDoubles = {
    _nullableArrayOfOneDoubles
  }

  def nullableArrayOfOneDoubles_= (value: Option[Array[Double]]) {
    _nullableArrayOfOneDoubles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableArrayOfOneDoubles")
  def calculatedNullableArrayOfOneDoubles = {
    _calculatedNullableArrayOfOneDoubles
  }

  def calculatedNullableArrayOfOneDoubles_= (value: Option[Array[Double]]) {
    _calculatedNullableArrayOfOneDoubles = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableArrayOfOneDoubles")
  def persistedNullableArrayOfOneDoubles = {
    _persistedNullableArrayOfOneDoubles
  }

  def persistedNullableArrayOfOneDoubles_= (value: Option[Array[Double]]) {
    _persistedNullableArrayOfOneDoubles = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableArrayOfOneDoubles") nullableArrayOfOneDoubles: Option[Array[Double]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableArrayOfOneDoubles") calculatedNullableArrayOfOneDoubles: Option[Array[Double]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableArrayOfOneDoubles") persistedNullableArrayOfOneDoubles: Option[Array[Double]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableArrayOfOneDoubles = nullableArrayOfOneDoubles, _calculatedNullableArrayOfOneDoubles = calculatedNullableArrayOfOneDoubles, _persistedNullableArrayOfOneDoubles = persistedNullableArrayOfOneDoubles)

}

object NullableArrayOfOneDoubles_3 extends AggregateRootCompanion[NullableArrayOfOneDoubles_3]{

  def apply(
    nullableArrayOfOneDoubles: Option[Array[Double]] = None
  ) = {
    require(nullableArrayOfOneDoubles ne null, "Null value was provided for property \"nullableArrayOfOneDoubles\"")
    if (nullableArrayOfOneDoubles.isDefined) require(nullableArrayOfOneDoubles.get ne null, "Null value was provided for property \"nullableArrayOfOneDoubles\"")
    new NullableArrayOfOneDoubles_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableArrayOfOneDoubles = nullableArrayOfOneDoubles
    , _calculatedNullableArrayOfOneDoubles = None
    , _persistedNullableArrayOfOneDoubles = None)
  }

}