package com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup

import com.dslplatform.api.patterns._
import com.dslplatform.api.client._
import scala.concurrent.{Await, Future, ExecutionContext}
import scala.concurrent.duration.Duration

class OneArrayOfOneFloats_2 @com.fasterxml.jackson.annotation.JsonIgnore() private(
    private var _URI: String,
    @transient private var __locator: Option[ServiceLocator],
    private var _oneArrayOfOneFloats: Array[Float]
  ) extends Serializable with AggregateRoot {

  @com.fasterxml.jackson.annotation.JsonProperty("URI")
  def URI = {

    _URI
  }

  override def hashCode = URI.hashCode
  override def equals(o: Any) = o match {
    case c: OneArrayOfOneFloats_2 => c.URI == URI
    case _ => false
  }

  override def toString = "OneArrayOfOneFloats_2("+ URI +")"

   def copy(oneArrayOfOneFloats: Array[Float] = this._oneArrayOfOneFloats): OneArrayOfOneFloats_2 = {

  require(oneArrayOfOneFloats ne null, "Null value was provided for property \"oneArrayOfOneFloats\"")
    new OneArrayOfOneFloats_2(_URI = this.URI, __locator = this.__locator, _oneArrayOfOneFloats = oneArrayOfOneFloats)
  }

  @com.fasterxml.jackson.annotation.JsonIgnore
  def isNewAggregate() = __locator == None

  private def updateWithAnother(result: com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneArrayOfOneFloats_2): this.type = {
    this._URI = result._URI
    this._oneArrayOfOneFloats = result._oneArrayOfOneFloats
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
    Await.result(__locator.get.resolve(classOf[CrudProxy]).delete[com.dslplatform.ocd.aggregates.PrimaryKeyPropertyInAggregateSetup.OneArrayOfOneFloats_2](URI), duration)
  }

  @com.fasterxml.jackson.annotation.JsonProperty("oneArrayOfOneFloats")
  @com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY)
  def oneArrayOfOneFloats = {
    _oneArrayOfOneFloats
  }

  def oneArrayOfOneFloats_= (value: Array[Float]) {
    _oneArrayOfOneFloats = value

  }

  @com.fasterxml.jackson.annotation.JsonCreator private def this(
    @com.fasterxml.jackson.annotation.JacksonInject("__locator") __locator: ServiceLocator
  , @com.fasterxml.jackson.annotation.JsonProperty("URI") URI: String
  , @com.fasterxml.jackson.annotation.JsonProperty("oneArrayOfOneFloats") oneArrayOfOneFloats: Array[Float]
  ) =
    this(__locator = Some(__locator), _URI = URI, _oneArrayOfOneFloats = if (oneArrayOfOneFloats == null) Array.empty else oneArrayOfOneFloats)

}

object OneArrayOfOneFloats_2 extends AggregateRootCompanion[OneArrayOfOneFloats_2]{

  def apply(
    oneArrayOfOneFloats: Array[Float] = Array.empty
  ) = {
    require(oneArrayOfOneFloats ne null, "Null value was provided for property \"oneArrayOfOneFloats\"")
    new OneArrayOfOneFloats_2(
      __locator = None
    , _URI = java.util.UUID.randomUUID.toString
    , _oneArrayOfOneFloats = oneArrayOfOneFloats)
  }

}