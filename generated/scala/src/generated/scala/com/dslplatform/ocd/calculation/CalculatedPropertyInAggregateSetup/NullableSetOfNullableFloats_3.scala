package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableSetOfNullableFloats_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableSetOfNullableFloats: Option[Set[Option[Float]]],
    private var _calculatedNullableSetOfNullableFloats: Option[Set[Option[Float]]],
    private var _persistedNullableSetOfNullableFloats: Option[Set[Option[Float]]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableSetOfNullableFloats_3 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableSetOfNullableFloats_3("+ URI +")"

   def copy(nullableSetOfNullableFloats: Option[Set[Option[Float]]] = this._nullableSetOfNullableFloats): NullableSetOfNullableFloats_3 = {

  require(nullableSetOfNullableFloats ne null, "Null value was provided for property \"nullableSetOfNullableFloats\"")
  if(nullableSetOfNullableFloats.isDefined) require(nullableSetOfNullableFloats.get ne null, "Null value was provided for property \"nullableSetOfNullableFloats\"")
  com.dslplatform.api.Guards.checkCollectionOptionValNulls(nullableSetOfNullableFloats)
    new NullableSetOfNullableFloats_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableSetOfNullableFloats = nullableSetOfNullableFloats, _calculatedNullableSetOfNullableFloats = _calculatedNullableSetOfNullableFloats, _persistedNullableSetOfNullableFloats = _persistedNullableSetOfNullableFloats)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfNullableFloats_3): this.type = {
    this._URI = result._URI
    this._nullableSetOfNullableFloats = result._nullableSetOfNullableFloats
    this._calculatedNullableSetOfNullableFloats = result._calculatedNullableSetOfNullableFloats
    this._persistedNullableSetOfNullableFloats = result._persistedNullableSetOfNullableFloats
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableSetOfNullableFloats_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableFloats")
  def nullableSetOfNullableFloats = {
    _nullableSetOfNullableFloats
  }

  def nullableSetOfNullableFloats_= (value: Option[Set[Option[Float]]]) {
    com.dslplatform.api.Guards.checkCollectionOptionValNulls(value)
    _nullableSetOfNullableFloats = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableSetOfNullableFloats")
  def calculatedNullableSetOfNullableFloats = {
    _calculatedNullableSetOfNullableFloats
  }

  def calculatedNullableSetOfNullableFloats_= (value: Option[Set[Option[Float]]]) {
    _calculatedNullableSetOfNullableFloats = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableSetOfNullableFloats")
  def persistedNullableSetOfNullableFloats = {
    _persistedNullableSetOfNullableFloats
  }

  def persistedNullableSetOfNullableFloats_= (value: Option[Set[Option[Float]]]) {
    _persistedNullableSetOfNullableFloats = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableFloats") nullableSetOfNullableFloats: Option[Set[Option[Float]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableSetOfNullableFloats") calculatedNullableSetOfNullableFloats: Option[Set[Option[Float]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableSetOfNullableFloats") persistedNullableSetOfNullableFloats: Option[Set[Option[Float]]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableSetOfNullableFloats = nullableSetOfNullableFloats, _calculatedNullableSetOfNullableFloats = calculatedNullableSetOfNullableFloats, _persistedNullableSetOfNullableFloats = persistedNullableSetOfNullableFloats)

}

object NullableSetOfNullableFloats_3 extends AggregateRootCompanion[NullableSetOfNullableFloats_3]{

  def apply(
    nullableSetOfNullableFloats: Option[Set[Option[Float]]] = None
  ) = {
    com.dslplatform.api.Guards.checkCollectionOptionValNulls(nullableSetOfNullableFloats)
    require(nullableSetOfNullableFloats ne null, "Null value was provided for property \"nullableSetOfNullableFloats\"")
    if (nullableSetOfNullableFloats.isDefined) require(nullableSetOfNullableFloats.get ne null, "Null value was provided for property \"nullableSetOfNullableFloats\"")
    new NullableSetOfNullableFloats_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableSetOfNullableFloats = nullableSetOfNullableFloats
    , _calculatedNullableSetOfNullableFloats = None
    , _persistedNullableSetOfNullableFloats = None)
  }

}