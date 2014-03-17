package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableArrayOfOneBinaries_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableArrayOfOneBinaries: Option[Array[Array[Byte]]],
    private var _calculatedNullableArrayOfOneBinaries: Option[Array[Array[Byte]]],
    private var _persistedNullableArrayOfOneBinaries: Option[Array[Array[Byte]]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableArrayOfOneBinaries_3 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableArrayOfOneBinaries_3("+ URI +")"

   def copy(nullableArrayOfOneBinaries: Option[Array[Array[Byte]]] = this._nullableArrayOfOneBinaries): NullableArrayOfOneBinaries_3 = {

  require(nullableArrayOfOneBinaries ne null, "Null value was provided for property \"nullableArrayOfOneBinaries\"")
  if(nullableArrayOfOneBinaries.isDefined) require(nullableArrayOfOneBinaries.get ne null, "Null value was provided for property \"nullableArrayOfOneBinaries\"")
  com.dslplatform.api.Guards.checkArrayNulls(nullableArrayOfOneBinaries)
    new NullableArrayOfOneBinaries_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableArrayOfOneBinaries = nullableArrayOfOneBinaries, _calculatedNullableArrayOfOneBinaries = _calculatedNullableArrayOfOneBinaries, _persistedNullableArrayOfOneBinaries = _persistedNullableArrayOfOneBinaries)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableArrayOfOneBinaries_3): this.type = {
    this._URI = result._URI
    this._nullableArrayOfOneBinaries = result._nullableArrayOfOneBinaries
    this._calculatedNullableArrayOfOneBinaries = result._calculatedNullableArrayOfOneBinaries
    this._persistedNullableArrayOfOneBinaries = result._persistedNullableArrayOfOneBinaries
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableArrayOfOneBinaries_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableArrayOfOneBinaries")
  def nullableArrayOfOneBinaries = {
    _nullableArrayOfOneBinaries
  }

  def nullableArrayOfOneBinaries_= (value: Option[Array[Array[Byte]]]) {
    com.dslplatform.api.Guards.checkArrayNulls(value)
    _nullableArrayOfOneBinaries = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableArrayOfOneBinaries")
  def calculatedNullableArrayOfOneBinaries = {
    _calculatedNullableArrayOfOneBinaries
  }

  def calculatedNullableArrayOfOneBinaries_= (value: Option[Array[Array[Byte]]]) {
    _calculatedNullableArrayOfOneBinaries = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableArrayOfOneBinaries")
  def persistedNullableArrayOfOneBinaries = {
    _persistedNullableArrayOfOneBinaries
  }

  def persistedNullableArrayOfOneBinaries_= (value: Option[Array[Array[Byte]]]) {
    _persistedNullableArrayOfOneBinaries = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableArrayOfOneBinaries") nullableArrayOfOneBinaries: Option[Array[Array[Byte]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableArrayOfOneBinaries") calculatedNullableArrayOfOneBinaries: Option[Array[Array[Byte]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableArrayOfOneBinaries") persistedNullableArrayOfOneBinaries: Option[Array[Array[Byte]]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableArrayOfOneBinaries = nullableArrayOfOneBinaries, _calculatedNullableArrayOfOneBinaries = calculatedNullableArrayOfOneBinaries, _persistedNullableArrayOfOneBinaries = persistedNullableArrayOfOneBinaries)

}

object NullableArrayOfOneBinaries_3 extends AggregateRootCompanion[NullableArrayOfOneBinaries_3]{

  def apply(
    nullableArrayOfOneBinaries: Option[Array[Array[Byte]]] = None
  ) = {
    com.dslplatform.api.Guards.checkArrayNulls(nullableArrayOfOneBinaries)
    require(nullableArrayOfOneBinaries ne null, "Null value was provided for property \"nullableArrayOfOneBinaries\"")
    if (nullableArrayOfOneBinaries.isDefined) require(nullableArrayOfOneBinaries.get ne null, "Null value was provided for property \"nullableArrayOfOneBinaries\"")
    new NullableArrayOfOneBinaries_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableArrayOfOneBinaries = nullableArrayOfOneBinaries
    , _calculatedNullableArrayOfOneBinaries = None
    , _persistedNullableArrayOfOneBinaries = None)
  }

}