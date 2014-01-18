package com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class NullableSetOfNullableXmls_2 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _nullableSetOfNullableXmls: Option[Set[Option[scala.xml.Elem]]]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: NullableSetOfNullableXmls_2 => c.URI == URI
    case _ => false
  }

  override def toString = "NullableSetOfNullableXmls_2("+ URI +")"

   def copy(nullableSetOfNullableXmls: Option[Set[Option[scala.xml.Elem]]] = this._nullableSetOfNullableXmls): NullableSetOfNullableXmls_2 = {

  require(nullableSetOfNullableXmls ne null, "Null value was provided for property \"nullableSetOfNullableXmls\"")
  if(nullableSetOfNullableXmls.isDefined) require(nullableSetOfNullableXmls.get ne null, "Null value was provided for property \"nullableSetOfNullableXmls\"")
  com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableXmls)
    new NullableSetOfNullableXmls_2(_URI = this.URI, __locator = this.__locator, _ID = _ID, _nullableSetOfNullableXmls = nullableSetOfNullableXmls)
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

  private def updateWithAnother(result: com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.NullableSetOfNullableXmls_2): this.type = {
    this._URI = result._URI
    this._nullableSetOfNullableXmls = result._nullableSetOfNullableXmls
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.aggregates.SurrogatePrimaryKeyWithOnePropertyInAggregate.NullableSetOfNullableXmls_2](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableXmls")
  def nullableSetOfNullableXmls = {
    _nullableSetOfNullableXmls
  }

  def nullableSetOfNullableXmls_= (value: Option[Set[Option[scala.xml.Elem]]]) {
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(value)
    _nullableSetOfNullableXmls = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("nullableSetOfNullableXmls") nullableSetOfNullableXmls: Option[Set[Option[scala.xml.Elem]]]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _nullableSetOfNullableXmls = nullableSetOfNullableXmls)

}

object NullableSetOfNullableXmls_2 extends AggregateRootCompanion[NullableSetOfNullableXmls_2]{

  def apply(
    nullableSetOfNullableXmls: Option[Set[Option[scala.xml.Elem]]] = None
  ) = {
    com.dslplatform.api.Guards.checkCollectionOptionRefNulls(nullableSetOfNullableXmls)
    require(nullableSetOfNullableXmls ne null, "Null value was provided for property \"nullableSetOfNullableXmls\"")
    if (nullableSetOfNullableXmls.isDefined) require(nullableSetOfNullableXmls.get ne null, "Null value was provided for property \"nullableSetOfNullableXmls\"")
    new NullableSetOfNullableXmls_2(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _nullableSetOfNullableXmls = nullableSetOfNullableXmls)
  }

}
