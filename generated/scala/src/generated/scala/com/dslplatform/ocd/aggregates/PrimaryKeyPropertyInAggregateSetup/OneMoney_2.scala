package com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneMoney_2 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _oneMoney: BigDecimal
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneMoney_2 => c.URI == URI
    case _ => false
  }

  override def toString = "OneMoney_2("+ URI +")"

   def copy(oneMoney: BigDecimal = this._oneMoney): OneMoney_2 = {

  require(oneMoney ne null, "Null value was provided for property \"oneMoney\"")
    new OneMoney_2(_URI = this.URI, __locator = this.__locator, _oneMoney = oneMoney)
  }

  @com.fasterxml.jackson.annotation.JsonIgnore
  def isNewAggregate() = __locator == None

  private def updateWithAnother(result: com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneMoney_2): this.type = {
    this._URI = result._URI
    this._oneMoney = result._oneMoney
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneMoney_2](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneMoney")
  def oneMoney = {
    _oneMoney
  }

  def oneMoney_= (value: BigDecimal) {
    _oneMoney = value

    _oneMoney = com.dslplatform.api.Guards.setScale(_oneMoney, 2)
  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("oneMoney") oneMoney: BigDecimal
  ) =
    this(__locator = Some(__locator), _URI = URI, _oneMoney = if (oneMoney == null) BigDecimal(0) else oneMoney)

}

object OneMoney_2 extends AggregateRootCompanion[OneMoney_2]{

  def apply(
    oneMoney: BigDecimal = BigDecimal(0)
  ) = {
    require(oneMoney ne null, "Null value was provided for property \"oneMoney\"")
    new OneMoney_2(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _oneMoney = oneMoney)
  }

}
