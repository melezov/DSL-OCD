package com.dslplatform.ocd
package boxes

trait `box.OneArrayOfNullable`
    extends OcdBox {

  type boxType = `box.OneArrayOfNullable`

  val boxClass = classOf[`box.OneArrayOfNullable`]

  val boxName = "OneArrayOfNullable"

  override val boxAliases = Set(
    "OneBracketsOfNullable"
  )
}

case object `box.OneArrayOfNullable` extends `box.OneArrayOfNullable`
