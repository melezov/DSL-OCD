package com.dslplatform.ocd
package dsls

import types._
import boxes._

sealed trait DslMoney
    extends OcdDslBoxType
    with `type.Money`

case object `dsl.Money`          extends DslMoney with `box.One`
case object `dsl.Money?`         extends DslMoney with `box.Nullable`
case object `dsl.Array<Money>`   extends DslMoney with `box.OneArrayOfOne`
case object `dsl.Money[]`        extends DslMoney with `box.OneBracketsOfOne`
case object `dsl.Array<Money>?`  extends DslMoney with `box.NullableArrayOfOne`
case object `dsl.Money[]?`       extends DslMoney with `box.NullableBracketsOfOne`
case object `dsl.Array<Money?>`  extends DslMoney with `box.OneArrayOfNullable`
case object `dsl.Money?[]`       extends DslMoney with `box.OneBracketsOfNullable`
case object `dsl.Array<Money?>?` extends DslMoney with `box.NullableArrayOfNullable`
case object `dsl.Money?[]?`      extends DslMoney with `box.NullableBracketsOfNullable`
case object `dsl.List<Money>`    extends DslMoney with `box.OneListOfOne`
case object `dsl.List<Money>?`   extends DslMoney with `box.NullableListOfOne`
case object `dsl.List<Money?>`   extends DslMoney with `box.OneListOfNullable`
case object `dsl.List<Money?>?`  extends DslMoney with `box.NullableListOfNullable`
case object `dsl.Set<Money>`     extends DslMoney with `box.OneSetOfOne`
case object `dsl.Set<Money>?`    extends DslMoney with `box.NullableSetOfOne`
case object `dsl.Set<Money?>`    extends DslMoney with `box.OneSetOfNullable`
case object `dsl.Set<Money?>?`   extends DslMoney with `box.NullableSetOfNullable`
