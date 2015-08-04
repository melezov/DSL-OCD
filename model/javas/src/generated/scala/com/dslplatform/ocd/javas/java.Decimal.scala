package com.dslplatform.ocd
package javas

import types._
import boxes._

sealed trait JavaDecimal
    extends OcdJavaBoxType
    with `type.Decimal` {

  val isPrecise = false
  val isPrimitive = false
}

case object `java.Decimal`
    extends JavaDecimal with `box.One` {

  val javaClass = "java.math.BigDecimal"
  val javaType = JavaSimpleType("java.math.BigDecimal")
  val javaDescription = "OneDecimal"

  def defaultValue = SingleJavaValue("java.math.BigDecimal.ZERO")

  def nonDefaultValues = IndexedSeq(
    SingleJavaValue("java.math.BigDecimal.ONE")
  , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
  , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
  , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
  )

  val hasGenerics = false
}

case object `java.Decimal?`
    extends JavaDecimal with `box.Nullable` {

  val javaClass = "java.math.BigDecimal"
  val javaType = JavaSimpleType("java.math.BigDecimal")
  val javaDescription = "NullableDecimal"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SingleJavaValue("java.math.BigDecimal.ZERO")
  , SingleJavaValue("java.math.BigDecimal.ONE")
  , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
  , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
  , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
  )

  val hasGenerics = false
}

case object `java.Decimal[]`
    extends JavaDecimal with `box.OneArrayOfOne` {

  val javaClass = "java.math.BigDecimal[]"
  val javaType = JavaSimpleType("java.math.BigDecimal[]")
  val javaDescription = "OneArrayOfOneDecimals"

  def defaultValue = SingleJavaValue("new java.math.BigDecimal[0]")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = false
}

case object `java.Decimal[]?`
    extends JavaDecimal with `box.NullableArrayOfOne` {

  val javaClass = "java.math.BigDecimal[]"
  val javaType = JavaSimpleType("java.math.BigDecimal[]")
  val javaDescription = "NullableArrayOfOneDecimals"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = false
}

case object `java.Decimal?[]`
    extends JavaDecimal with `box.OneArrayOfNullable` {

  val javaClass = "java.math.BigDecimal[]"
  val javaType = JavaSimpleType("java.math.BigDecimal[]")
  val javaDescription = "OneArrayOfNullableDecimals"

  def defaultValue = SingleJavaValue("new java.math.BigDecimal[0]")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    , SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = false
}

case object `java.Decimal?[]?`
    extends JavaDecimal with `box.NullableArrayOfNullable` {

  val javaClass = "java.math.BigDecimal[]"
  val javaType = JavaSimpleType("java.math.BigDecimal[]")
  val javaDescription = "NullableArrayOfNullableDecimals"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ArrayOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    , SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = false
}

case object `java.List<Decimal>`
    extends JavaDecimal with `box.OneListOfOne` {

  val javaClass = "java.util.List<java.math.BigDecimal>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("java.math.BigDecimal"))
  val javaDescription = "OneListOfOneDecimals"

  def defaultValue = SingleJavaValue("new java.util.ArrayList<java.math.BigDecimal>(0)")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = true
}

case object `java.List<Decimal>?`
    extends JavaDecimal with `box.NullableListOfOne` {

  val javaClass = "java.util.List<java.math.BigDecimal>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("java.math.BigDecimal"))
  val javaDescription = "NullableListOfOneDecimals"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = true
}

case object `java.List<Decimal?>`
    extends JavaDecimal with `box.OneListOfNullable` {

  val javaClass = "java.util.List<java.math.BigDecimal>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("java.math.BigDecimal"))
  val javaDescription = "OneListOfNullableDecimals"

  def defaultValue = SingleJavaValue("new java.util.ArrayList<java.math.BigDecimal>(0)")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    , SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = true
}

case object `java.List<Decimal?>?`
    extends JavaDecimal with `box.NullableListOfNullable` {

  val javaClass = "java.util.List<java.math.BigDecimal>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("java.math.BigDecimal"))
  val javaDescription = "NullableListOfNullableDecimals"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , ListOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    , SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Decimal>`
    extends JavaDecimal with `box.OneSetOfOne` {

  val javaClass = "java.util.Set<java.math.BigDecimal>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("java.math.BigDecimal"))
  val javaDescription = "OneSetOfOneDecimals"

  def defaultValue = SingleJavaValue("new java.util.HashSet<java.math.BigDecimal>(0)")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Decimal>?`
    extends JavaDecimal with `box.NullableSetOfOne` {

  val javaClass = "java.util.Set<java.math.BigDecimal>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("java.math.BigDecimal"))
  val javaDescription = "NullableSetOfOneDecimals"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Decimal?>`
    extends JavaDecimal with `box.OneSetOfNullable` {

  val javaClass = "java.util.Set<java.math.BigDecimal>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("java.math.BigDecimal"))
  val javaDescription = "OneSetOfNullableDecimals"

  def defaultValue = SingleJavaValue("new java.util.HashSet<java.math.BigDecimal>(0)")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    , SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Decimal?>?`
    extends JavaDecimal with `box.NullableSetOfNullable` {

  val javaClass = "java.util.Set<java.math.BigDecimal>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("java.math.BigDecimal"))
  val javaDescription = "NullableSetOfNullableDecimals"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  , SetOfJavaValues("java.math.BigDecimal",
      SingleJavaValue("null")
    , SingleJavaValue("java.math.BigDecimal.ZERO")
    , SingleJavaValue("java.math.BigDecimal.ONE")
    , SingleJavaValue("new java.math.BigDecimal(\"3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679\").setScale(28, java.math.BigDecimal.ROUND_HALF_UP)")
    , SingleJavaValue("new java.math.BigDecimal(\"-1E-28\")")
    , SingleJavaValue("new java.math.BigDecimal(\"1E28\")")
    )
  )

  val hasGenerics = true
}