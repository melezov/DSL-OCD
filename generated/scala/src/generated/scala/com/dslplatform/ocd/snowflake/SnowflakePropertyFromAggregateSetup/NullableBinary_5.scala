package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableBinary_5 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableBinary: Option[Array[Byte]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableBinary_5 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableBinary_5("+ URI +")"

   def copy(nullableBinary: Option[Array[Byte]] = this._nullableBinary): NullableBinary_5 = {

  require(nullableBinary ne null, "Null value was provided for property \"nullableBinary\"")
  if(nullableBinary.isDefined) require(nullableBinary.get ne null, "Null value was provided for property \"nullableBinary\"")
    new NullableBinary_5(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableBinary = nullableBinary)
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

  private def updateWithAnother(result: com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.NullableBinary_5): this.type = {
    this._URI = result._URI
    this._nullableBinary = result._nullableBinary
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.NullableBinary_5](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableBinary")
  def nullableBinary = {
    _nullableBinary
  }

  def nullableBinary_= (value: Option[Array[Byte]]) {
    _nullableBinary = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableBinary") nullableBinary: Option[Array[Byte]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableBinary = nullableBinary)

}

object NullableBinary_5 extends AggregateRootCompanion[NullableBinary_5]{

  def apply(
    nullableBinary: Option[Array[Byte]] = None
  ) = {
    require(nullableBinary ne null, "Null value was provided for property \"nullableBinary\"")
    if (nullableBinary.isDefined) require(nullableBinary.get ne null, "Null value was provided for property \"nullableBinary\"")
    new NullableBinary_5(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableBinary = nullableBinary)
  }

}