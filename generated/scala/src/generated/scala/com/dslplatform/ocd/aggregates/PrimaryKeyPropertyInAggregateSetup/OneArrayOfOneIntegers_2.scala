package com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneArrayOfOneIntegers_2 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _oneArrayOfOneIntegers: Array[Int]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneArrayOfOneIntegers_2 => c.URI == URI
    case _ => false
  }

  override def toString = "OneArrayOfOneIntegers_2("+ URI +")"

   def copy(oneArrayOfOneIntegers: Array[Int] = this._oneArrayOfOneIntegers): OneArrayOfOneIntegers_2 = {

  require(oneArrayOfOneIntegers ne null, "Null value was provided for property \"oneArrayOfOneIntegers\"")
    new OneArrayOfOneIntegers_2(_URI = this.URI, __locator = this.__locator, _oneArrayOfOneIntegers = oneArrayOfOneIntegers)
  }

  @com.fasterxml.jackson.annotation.JsonIgnore
  def isNewAggregate() = __locator == None

  private def updateWithAnother(result: com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneArrayOfOneIntegers_2): this.type = {
    this._URI = result._URI
    this._oneArrayOfOneIntegers = result._oneArrayOfOneIntegers
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneArrayOfOneIntegers_2](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneArrayOfOneIntegers")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneArrayOfOneIntegers = {
    _oneArrayOfOneIntegers
  }

  def oneArrayOfOneIntegers_= (value: Array[Int]) {
    _oneArrayOfOneIntegers = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("oneArrayOfOneIntegers") oneArrayOfOneIntegers: Array[Int]
  ) =
    this(__locator = Some(__locator), _URI = URI, _oneArrayOfOneIntegers = if (oneArrayOfOneIntegers == null) Array.empty else oneArrayOfOneIntegers)

}

object OneArrayOfOneIntegers_2 extends AggregateRootCompanion[OneArrayOfOneIntegers_2]{

  def apply(
    oneArrayOfOneIntegers: Array[Int] = Array.empty
  ) = {
    require(oneArrayOfOneIntegers ne null, "Null value was provided for property \"oneArrayOfOneIntegers\"")
    new OneArrayOfOneIntegers_2(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _oneArrayOfOneIntegers = oneArrayOfOneIntegers)
  }

}