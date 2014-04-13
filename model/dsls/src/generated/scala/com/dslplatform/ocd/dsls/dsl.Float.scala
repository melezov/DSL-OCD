package com.dslplatform.ocd
package dsls

import types._
import boxes._

sealed trait DslFloat
    extends OcdDslBoxType
    with `type.Float`

case object `dsl.Float`          extends DslFloat with `box.One`
case object `dsl.Float?`         extends DslFloat with `box.Nullable`
case object `dsl.Array<Float>`   extends DslFloat with `box.OneArrayOfOne`
case object `dsl.Float[]`        extends DslFloat with `box.OneBracketsOfOne`
case object `dsl.Array<Float>?`  extends DslFloat with `box.NullableArrayOfOne`
case object `dsl.Float[]?`       extends DslFloat with `box.NullableBracketsOfOne`
case object `dsl.Array<Float?>`  extends DslFloat with `box.OneArrayOfNullable`
case object `dsl.Float?[]`       extends DslFloat with `box.OneBracketsOfNullable`
case object `dsl.Array<Float?>?` extends DslFloat with `box.NullableArrayOfNullable`
case object `dsl.Float?[]?`      extends DslFloat with `box.NullableBracketsOfNullable`
case object `dsl.List<Float>`    extends DslFloat with `box.OneListOfOne`
case object `dsl.List<Float>?`   extends DslFloat with `box.NullableListOfOne`
case object `dsl.List<Float?>`   extends DslFloat with `box.OneListOfNullable`
case object `dsl.List<Float?>?`  extends DslFloat with `box.NullableListOfNullable`
case object `dsl.Set<Float>`     extends DslFloat with `box.OneSetOfOne`
case object `dsl.Set<Float>?`    extends DslFloat with `box.NullableSetOfOne`
case object `dsl.Set<Float?>`    extends DslFloat with `box.OneSetOfNullable`
case object `dsl.Set<Float?>?`   extends DslFloat with `box.NullableSetOfNullable`
