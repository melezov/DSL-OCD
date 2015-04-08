package com.dslplatform.ocd
package javas

import types._
import boxes._

sealed trait JavaLong
    extends OcdJavaBoxType
    with `type.Long` {

  val isPrecise = false
  val isPrimitive = true
}

case object `java.Long`
    extends JavaLong with `box.One` {

  val javaClass = "long"
  val javaType = JavaSimpleType("long")
  val javaDescription = "OneLong"

  def defaultValue = SingleJavaValue("0L")

  def nonDefaultValues = IndexedSeq(
    SingleJavaValue("1L")
  , SingleJavaValue("1000000000000000000L")
  , SingleJavaValue("-1000000000000000000L")
  , SingleJavaValue("Long.MIN_VALUE")
  , SingleJavaValue("Long.MAX_VALUE")
  )

  val hasGenerics = false
}

case object `java.Long?`
    extends JavaLong with `box.Nullable` {

  val javaClass = "Long"
  val javaType = JavaSimpleType("Long")
  val javaDescription = "NullableLong"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SingleJavaValue("0L")
  , SingleJavaValue("1L")
  , SingleJavaValue("1000000000000000000L")
  , SingleJavaValue("-1000000000000000000L")
  , SingleJavaValue("Long.MIN_VALUE")
  , SingleJavaValue("Long.MAX_VALUE")
  )

  val hasGenerics = false
}

case object `java.Long[]`
    extends JavaLong with `box.OneArrayOfOne` {

  val javaClass = "long[]"
  val javaType = JavaSimpleType("long[]")
  val javaDescription = "OneArrayOfOneLongs"

  def defaultValue = SingleJavaValue("new long[0]")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("long",
      SingleJavaValue("0L")
    )
  , ArrayOfJavaValues("long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , ArrayOfJavaValues("long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = false
}

case object `java.Long[]?`
    extends JavaLong with `box.NullableArrayOfOne` {

  val javaClass = "long[]"
  val javaType = JavaSimpleType("long[]")
  val javaDescription = "NullableArrayOfOneLongs"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("long",
      SingleJavaValue("0L")
    )
  , ArrayOfJavaValues("long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , ArrayOfJavaValues("long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = false
}

case object `java.Long?[]`
    extends JavaLong with `box.OneArrayOfNullable` {

  val javaClass = "Long[]"
  val javaType = JavaSimpleType("Long[]")
  val javaDescription = "OneArrayOfNullableLongs"

  def defaultValue = SingleJavaValue("new Long[0]")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("Long",
      SingleJavaValue("null")
    )
  , ArrayOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , ArrayOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , ArrayOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  , ArrayOfJavaValues("Long",
      SingleJavaValue("null")
    , SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = false
}

case object `java.Long?[]?`
    extends JavaLong with `box.NullableArrayOfNullable` {

  val javaClass = "Long[]"
  val javaType = JavaSimpleType("Long[]")
  val javaDescription = "NullableArrayOfNullableLongs"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("Long",
      SingleJavaValue("null")
    )
  , ArrayOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , ArrayOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , ArrayOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  , ArrayOfJavaValues("Long",
      SingleJavaValue("null")
    , SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = false
}

case object `java.List<Long>`
    extends JavaLong with `box.OneListOfOne` {

  val javaClass = "java.util.List<Long>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("Long"))
  val javaDescription = "OneListOfOneLongs"

  def defaultValue = SingleJavaValue("new java.util.ArrayList<Long>(0)")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = true
}

case object `java.List<Long>?`
    extends JavaLong with `box.NullableListOfOne` {

  val javaClass = "java.util.List<Long>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("Long"))
  val javaDescription = "NullableListOfOneLongs"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = true
}

case object `java.List<Long?>`
    extends JavaLong with `box.OneListOfNullable` {

  val javaClass = "java.util.List<Long>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("Long"))
  val javaDescription = "OneListOfNullableLongs"

  def defaultValue = SingleJavaValue("new java.util.ArrayList<Long>(0)")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("Long",
      SingleJavaValue("null")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("null")
    , SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = true
}

case object `java.List<Long?>?`
    extends JavaLong with `box.NullableListOfNullable` {

  val javaClass = "java.util.List<Long>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("Long"))
  val javaDescription = "NullableListOfNullableLongs"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("Long",
      SingleJavaValue("null")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  , ListOfJavaValues("Long",
      SingleJavaValue("null")
    , SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Long>`
    extends JavaLong with `box.OneSetOfOne` {

  val javaClass = "java.util.Set<Long>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("Long"))
  val javaDescription = "OneSetOfOneLongs"

  def defaultValue = SingleJavaValue("new java.util.HashSet<Long>(0)")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Long>?`
    extends JavaLong with `box.NullableSetOfOne` {

  val javaClass = "java.util.Set<Long>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("Long"))
  val javaDescription = "NullableSetOfOneLongs"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Long?>`
    extends JavaLong with `box.OneSetOfNullable` {

  val javaClass = "java.util.Set<Long>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("Long"))
  val javaDescription = "OneSetOfNullableLongs"

  def defaultValue = SingleJavaValue("new java.util.HashSet<Long>(0)")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("Long",
      SingleJavaValue("null")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("null")
    , SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Long?>?`
    extends JavaLong with `box.NullableSetOfNullable` {

  val javaClass = "java.util.Set<Long>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("Long"))
  val javaDescription = "NullableSetOfNullableLongs"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("Long",
      SingleJavaValue("null")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("0L")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("Long.MAX_VALUE")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  , SetOfJavaValues("Long",
      SingleJavaValue("null")
    , SingleJavaValue("0L")
    , SingleJavaValue("1L")
    , SingleJavaValue("1000000000000000000L")
    , SingleJavaValue("-1000000000000000000L")
    , SingleJavaValue("Long.MIN_VALUE")
    , SingleJavaValue("Long.MAX_VALUE")
    )
  )

  val hasGenerics = true
}