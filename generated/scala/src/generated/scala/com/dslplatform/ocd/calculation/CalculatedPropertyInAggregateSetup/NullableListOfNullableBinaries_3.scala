package com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableListOfNullableBinaries_3 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableListOfNullableBinaries: Option[IndexedSeq[Option[Array[Byte]]]],
    private var _calculatedNullableListOfNullableBinaries: Option[IndexedSeq[Option[Array[Byte]]]],
    private var _persistedNullableListOfNullableBinaries: Option[IndexedSeq[Option[Array[Byte]]]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableListOfNullableBinaries_3 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableListOfNullableBinaries_3("+ URI +")"

   def copy(nullableListOfNullableBinaries: Option[IndexedSeq[Option[Array[Byte]]]] = this._nullableListOfNullableBinaries): NullableListOfNullableBinaries_3 = {

  require(nullableListOfNullableBinaries ne null, "Null value was provided for property \"nullableListOfNullableBinaries\"")
  if(nullableListOfNullableBinaries.isDefined) require(nullableListOfNullableBinaries.get ne null, "Null value was provided for property \"nullableListOfNullableBinaries\"")
  com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableListOfNullableBinaries)
    new NullableListOfNullableBinaries_3(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableListOfNullableBinaries = nullableListOfNullableBinaries, _calculatedNullableListOfNullableBinaries = _calculatedNullableListOfNullableBinaries, _persistedNullableListOfNullableBinaries = _persistedNullableListOfNullableBinaries)
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

  private def updateWithAnother(result: com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableListOfNullableBinaries_3): this.type = {
    this._URI = result._URI
    this._nullableListOfNullableBinaries = result._nullableListOfNullableBinaries
    this._calculatedNullableListOfNullableBinaries = result._calculatedNullableListOfNullableBinaries
    this._persistedNullableListOfNullableBinaries = result._persistedNullableListOfNullableBinaries
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.calculation.CalculatedPropertyInAggregateSetup.NullableListOfNullableBinaries_3](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableListOfNullableBinaries")
  def nullableListOfNullableBinaries = {
    _nullableListOfNullableBinaries
  }

  def nullableListOfNullableBinaries_= (value: Option[IndexedSeq[Option[Array[Byte]]]]) {
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(value)
    _nullableListOfNullableBinaries = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableListOfNullableBinaries")
  def calculatedNullableListOfNullableBinaries = {
    _calculatedNullableListOfNullableBinaries
  }

  def calculatedNullableListOfNullableBinaries_= (value: Option[IndexedSeq[Option[Array[Byte]]]]) {
    _calculatedNullableListOfNullableBinaries = value

  }

  @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableListOfNullableBinaries")
  def persistedNullableListOfNullableBinaries = {
    _persistedNullableListOfNullableBinaries
  }

  def persistedNullableListOfNullableBinaries_= (value: Option[IndexedSeq[Option[Array[Byte]]]]) {
    _persistedNullableListOfNullableBinaries = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableListOfNullableBinaries") nullableListOfNullableBinaries: Option[IndexedSeq[Option[Array[Byte]]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("calculatedNullableListOfNullableBinaries") calculatedNullableListOfNullableBinaries: Option[IndexedSeq[Option[Array[Byte]]]]
  , @com.fasterxml.jackson.annotation.JsonProperty("persistedNullableListOfNullableBinaries") persistedNullableListOfNullableBinaries: Option[IndexedSeq[Option[Array[Byte]]]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableListOfNullableBinaries = nullableListOfNullableBinaries, _calculatedNullableListOfNullableBinaries = calculatedNullableListOfNullableBinaries, _persistedNullableListOfNullableBinaries = persistedNullableListOfNullableBinaries)

}

object NullableListOfNullableBinaries_3 extends AggregateRootCompanion[NullableListOfNullableBinaries_3]{

  def apply(
    nullableListOfNullableBinaries: Option[IndexedSeq[Option[Array[Byte]]]] = None
  ) = {
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableListOfNullableBinaries)
    require(nullableListOfNullableBinaries ne null, "Null value was provided for property \"nullableListOfNullableBinaries\"")
    if (nullableListOfNullableBinaries.isDefined) require(nullableListOfNullableBinaries.get ne null, "Null value was provided for property \"nullableListOfNullableBinaries\"")
    new NullableListOfNullableBinaries_3(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableListOfNullableBinaries = nullableListOfNullableBinaries
    , _calculatedNullableListOfNullableBinaries = None
    , _persistedNullableListOfNullableBinaries = None)
  }

}
