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
case object `dsl.Queue<Float>`   extends DslFloat with `box.OneQueueOfOne`
case object `dsl.Queue<Float>?`  extends DslFloat with `box.NullableQueueOfOne`
case object `dsl.Queue<Float?>`  extends DslFloat with `box.OneQueueOfNullable`
case object `dsl.Queue<Float?>?` extends DslFloat with `box.NullableQueueOfNullable`
case object `dsl.Set<Float>`     extends DslFloat with `box.OneSetOfOne`
case object `dsl.Set<Float>?`    extends DslFloat with `box.NullableSetOfOne`
case object `dsl.Set<Float?>`    extends DslFloat with `box.OneSetOfNullable`
case object `dsl.Set<Float?>?`   extends DslFloat with `box.NullableSetOfNullable`

case object `dsl.FLOAT`          extends DslFloat with `box.One`
case object `dsl.FLOAT?`         extends DslFloat with `box.Nullable`
case object `dsl.ARRAY<FLOAT>`   extends DslFloat with `box.OneArrayOfOne`
case object `dsl.FLOAT[]`        extends DslFloat with `box.OneBracketsOfOne`
case object `dsl.ARRAY<FLOAT>?`  extends DslFloat with `box.NullableArrayOfOne`
case object `dsl.FLOAT[]?`       extends DslFloat with `box.NullableBracketsOfOne`
case object `dsl.ARRAY<FLOAT?>`  extends DslFloat with `box.OneArrayOfNullable`
case object `dsl.FLOAT?[]`       extends DslFloat with `box.OneBracketsOfNullable`
case object `dsl.ARRAY<FLOAT?>?` extends DslFloat with `box.NullableArrayOfNullable`
case object `dsl.FLOAT?[]?`      extends DslFloat with `box.NullableBracketsOfNullable`
case object `dsl.LIST<FLOAT>`    extends DslFloat with `box.OneListOfOne`
case object `dsl.LIST<FLOAT>?`   extends DslFloat with `box.NullableListOfOne`
case object `dsl.LIST<FLOAT?>`   extends DslFloat with `box.OneListOfNullable`
case object `dsl.LIST<FLOAT?>?`  extends DslFloat with `box.NullableListOfNullable`
case object `dsl.QUEUE<FLOAT>`   extends DslFloat with `box.OneQueueOfOne`
case object `dsl.QUEUE<FLOAT>?`  extends DslFloat with `box.NullableQueueOfOne`
case object `dsl.QUEUE<FLOAT?>`  extends DslFloat with `box.OneQueueOfNullable`
case object `dsl.QUEUE<FLOAT?>?` extends DslFloat with `box.NullableQueueOfNullable`
case object `dsl.SET<FLOAT>`     extends DslFloat with `box.OneSetOfOne`
case object `dsl.SET<FLOAT>?`    extends DslFloat with `box.NullableSetOfOne`
case object `dsl.SET<FLOAT?>`    extends DslFloat with `box.OneSetOfNullable`
case object `dsl.SET<FLOAT?>?`   extends DslFloat with `box.NullableSetOfNullable`

case object `dsl.float`          extends DslFloat with `box.One`
case object `dsl.float?`         extends DslFloat with `box.Nullable`
case object `dsl.array<float>`   extends DslFloat with `box.OneArrayOfOne`
case object `dsl.float[]`        extends DslFloat with `box.OneBracketsOfOne`
case object `dsl.array<float>?`  extends DslFloat with `box.NullableArrayOfOne`
case object `dsl.float[]?`       extends DslFloat with `box.NullableBracketsOfOne`
case object `dsl.array<float?>`  extends DslFloat with `box.OneArrayOfNullable`
case object `dsl.float?[]`       extends DslFloat with `box.OneBracketsOfNullable`
case object `dsl.array<float?>?` extends DslFloat with `box.NullableArrayOfNullable`
case object `dsl.float?[]?`      extends DslFloat with `box.NullableBracketsOfNullable`
case object `dsl.list<float>`    extends DslFloat with `box.OneListOfOne`
case object `dsl.list<float>?`   extends DslFloat with `box.NullableListOfOne`
case object `dsl.list<float?>`   extends DslFloat with `box.OneListOfNullable`
case object `dsl.list<float?>?`  extends DslFloat with `box.NullableListOfNullable`
case object `dsl.queue<float>`   extends DslFloat with `box.OneQueueOfOne`
case object `dsl.queue<float>?`  extends DslFloat with `box.NullableQueueOfOne`
case object `dsl.queue<float?>`  extends DslFloat with `box.OneQueueOfNullable`
case object `dsl.queue<float?>?` extends DslFloat with `box.NullableQueueOfNullable`
case object `dsl.set<float>`     extends DslFloat with `box.OneSetOfOne`
case object `dsl.set<float>?`    extends DslFloat with `box.NullableSetOfOne`
case object `dsl.set<float?>`    extends DslFloat with `box.OneSetOfNullable`
case object `dsl.set<float?>?`   extends DslFloat with `box.NullableSetOfNullable`