package com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneSetOfOnePoints_5 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _ID: Int,
    private var _oneSetOfOnePoints: Set[java.awt.geom.Point2D]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneSetOfOnePoints_5 => c.URI == URI
    case _ => false
  }

  override def toString = "OneSetOfOnePoints_5("+ URI +")"

   def copy(oneSetOfOnePoints: Set[java.awt.geom.Point2D] = this._oneSetOfOnePoints): OneSetOfOnePoints_5 = {

  require(oneSetOfOnePoints ne null, "Null value was provided for property \"oneSetOfOnePoints\"")
  com.dslplatform.api.Guards.checkCollectionNulls(oneSetOfOnePoints)
    new OneSetOfOnePoints_5(_URI = this.URI, __locator = this.__locator, _ID = _ID, _oneSetOfOnePoints = oneSetOfOnePoints)
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

  private def updateWithAnother(result: com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.OneSetOfOnePoints_5): this.type = {
    this._URI = result._URI
    this._oneSetOfOnePoints = result._oneSetOfOnePoints
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.snowflake.SnowflakePropertyFromAggregateSetup.OneSetOfOnePoints_5](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneSetOfOnePoints")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneSetOfOnePoints = {
    _oneSetOfOnePoints
  }

  def oneSetOfOnePoints_= (value: Set[java.awt.geom.Point2D]) {
    com.dslplatform.api.Guards.checkCollectionNulls(value)
    _oneSetOfOnePoints = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("ID") ID: Int
  , @com.fasterxml.jackson.annotation.JsonProperty("oneSetOfOnePoints") oneSetOfOnePoints: Set[java.awt.geom.Point2D]
  ) =
    this(__locator = Some(__locator), _URI = URI, _ID = ID, _oneSetOfOnePoints = if (oneSetOfOnePoints == null) Set.empty else oneSetOfOnePoints)

}

object OneSetOfOnePoints_5 extends AggregateRootCompanion[OneSetOfOnePoints_5]{

  def apply(
    oneSetOfOnePoints: Set[java.awt.geom.Point2D] = Set.empty
  ) = {
    com.dslplatform.api.Guards.checkCollectionNulls(oneSetOfOnePoints)
    require(oneSetOfOnePoints ne null, "Null value was provided for property \"oneSetOfOnePoints\"")
    new OneSetOfOnePoints_5(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _ID = 0
    , _oneSetOfOnePoints = oneSetOfOnePoints)
  }

}
