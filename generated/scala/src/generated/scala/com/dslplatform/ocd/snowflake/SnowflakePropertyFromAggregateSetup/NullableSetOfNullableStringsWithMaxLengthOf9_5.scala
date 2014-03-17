package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableSetOfNullableStringsWithMaxLengthOf9_5 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableSetOfNullableStringsWithMaxLengthOf9: Option[Set[Option[String]]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableSetOfNullableStringsWithMaxLengthOf9_5 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableSetOfNullableStringsWithMaxLengthOf9_5("+ URI +")"

   def copy(nullableSetOfNullableStringsWithMaxLengthOf9: Option[Set[Option[String]]] = this._nullableSetOfNullableStringsWithMaxLengthOf9): NullableSetOfNullableStringsWithMaxLengthOf9_5 = {

  require(nullableSetOfNullableStringsWithMaxLengthOf9 ne null, "Null value was provided for property \"nullableSetOfNullableStringsWithMaxLengthOf9\"")
  if(nullableSetOfNullableStringsWithMaxLengthOf9.isDefined) require(nullableSetOfNullableStringsWithMaxLengthOf9.get ne null, "Null value was provided for property \"nullableSetOfNullableStringsWithMaxLengthOf9\"")
  com.dslplatform.api.Guards.checkCollectionOptionLength(nullableSetOfNullableStringsWithMaxLengthOf9, 9)
  com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableStringsWithMaxLengthOf9)
    new NullableSetOfNullableStringsWithMaxLengthOf9_5(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableSetOfNullableStringsWithMaxLengthOf9 = nullableSetOfNullableStringsWithMaxLengthOf9)
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

  private def updateWithAnother(result: com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.NullableSetOfNullableStringsWithMaxLengthOf9_5): this.type = {
    this._URI = result._URI
    this._nullableSetOfNullableStringsWithMaxLengthOf9 = result._nullableSetOfNullableStringsWithMaxLengthOf9
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.NullableSetOfNullableStringsWithMaxLengthOf9_5](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableStringsWithMaxLengthOf9")
  def nullableSetOfNullableStringsWithMaxLengthOf9 = {
    _nullableSetOfNullableStringsWithMaxLengthOf9
  }

  def nullableSetOfNullableStringsWithMaxLengthOf9_= (value: Option[Set[Option[String]]]) {
    com.dslplatform.api.Guards.checkCollectionOptionLength(value, 9)
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(value)
    _nullableSetOfNullableStringsWithMaxLengthOf9 = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableStringsWithMaxLengthOf9") nullableSetOfNullableStringsWithMaxLengthOf9: Option[Set[Option[String]]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableSetOfNullableStringsWithMaxLengthOf9 = nullableSetOfNullableStringsWithMaxLengthOf9)

}

object NullableSetOfNullableStringsWithMaxLengthOf9_5 extends AggregateRootCompanion[NullableSetOfNullableStringsWithMaxLengthOf9_5]{

  def apply(
    nullableSetOfNullableStringsWithMaxLengthOf9: Option[Set[Option[String]]] = None
  ) = {
    com.dslplatform.api.Guards.checkCollectionOptionLength(nullableSetOfNullableStringsWithMaxLengthOf9, 9)
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableStringsWithMaxLengthOf9)
    require(nullableSetOfNullableStringsWithMaxLengthOf9 ne null, "Null value was provided for property \"nullableSetOfNullableStringsWithMaxLengthOf9\"")
    if (nullableSetOfNullableStringsWithMaxLengthOf9.isDefined) require(nullableSetOfNullableStringsWithMaxLengthOf9.get ne null, "Null value was provided for property \"nullableSetOfNullableStringsWithMaxLengthOf9\"")
    new NullableSetOfNullableStringsWithMaxLengthOf9_5(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableSetOfNullableStringsWithMaxLengthOf9 = nullableSetOfNullableStringsWithMaxLengthOf9)
  }

}