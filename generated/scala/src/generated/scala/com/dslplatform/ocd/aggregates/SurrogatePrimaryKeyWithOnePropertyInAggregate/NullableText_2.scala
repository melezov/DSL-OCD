package com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableText_2 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableText: Option[String]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableText_2 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableText_2("+ URI +")"

   def copy(nullableText: Option[String] = this._nullableText): NullableText_2 = {

  require(nullableText ne null, "Null value was provided for property \"nullableText\"")
  if(nullableText.isDefined) require(nullableText.get ne null, "Null value was provided for property \"nullableText\"")
    new NullableText_2(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableText = nullableText)
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

  private def updateWithAnother(result: com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.NullableText_2): this.type = {
    this._URI = result._URI
    this._nullableText = result._nullableText
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.NullableText_2](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableText")
  def nullableText = {
    _nullableText
  }

  def nullableText_= (value: Option[String]) {
    _nullableText = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableText") nullableText: Option[String]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableText = nullableText)

}

object NullableText_2 extends AggregateRootCompanion[NullableText_2]{

  def apply(
    nullableText: Option[String] = None
  ) = {
    require(nullableText ne null, "Null value was provided for property \"nullableText\"")
    if (nullableText.isDefined) require(nullableText.get ne null, "Null value was provided for property \"nullableText\"")
    new NullableText_2(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableText = nullableText)
  }

}
