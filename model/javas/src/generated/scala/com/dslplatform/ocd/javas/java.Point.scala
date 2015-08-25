package com.dslplatform.ocd
package javas

import types._
import boxes._

sealed abstract class JavaPoint
    extends OcdJavaBoxType
    with `type.Point` {

  val isPrecise = false
  val isPrimitive = false
  val isEqualable = true
}

case object `java.Point`
    extends JavaPoint with `box.One` {

  val javaClass = "java.awt.Point"
  val javaType = JavaSimpleType("java.awt.Point")
  val javaDescription = "OnePoint"

  def defaultValue = SingleJavaValue("new java.awt.Point()")

  def nonDefaultValues = IndexedSeq(
    SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
  , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
  , SingleJavaValue("new java.awt.Point(0, -1000000000)")
  , SingleJavaValue("new java.awt.Point(0, 1000000000)")
  )

  val hasGenerics = false
}

case object `java.Point?`
    extends JavaPoint with `box.Nullable` {

  val javaClass = "java.awt.Point"
  val javaType = JavaSimpleType("java.awt.Point")
  val javaDescription = "NullablePoint"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SingleJavaValue("new java.awt.Point()")
  , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
  , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
  , SingleJavaValue("new java.awt.Point(0, -1000000000)")
  , SingleJavaValue("new java.awt.Point(0, 1000000000)")
  )

  val hasGenerics = false
}

case object `java.Point[]`
    extends JavaPoint with `box.OneArrayOfOne` {

  val javaClass = "java.awt.Point[]"
  val javaType = JavaSimpleType("java.awt.Point[]")
  val javaDescription = "OneArrayOfOnePoints"

  def defaultValue = SingleJavaValue("new java.awt.Point[0]")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = false
}

case object `java.Point[]?`
    extends JavaPoint with `box.NullableArrayOfOne` {

  val javaClass = "java.awt.Point[]"
  val javaType = JavaSimpleType("java.awt.Point[]")
  val javaDescription = "NullableArrayOfOnePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = false
}

case object `java.Point?[]`
    extends JavaPoint with `box.OneArrayOfNullable` {

  val javaClass = "java.awt.Point[]"
  val javaType = JavaSimpleType("java.awt.Point[]")
  val javaDescription = "OneArrayOfNullablePoints"

  def defaultValue = SingleJavaValue("new java.awt.Point[0]")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = false
}

case object `java.Point?[]?`
    extends JavaPoint with `box.NullableArrayOfNullable` {

  val javaClass = "java.awt.Point[]"
  val javaType = JavaSimpleType("java.awt.Point[]")
  val javaDescription = "NullableArrayOfNullablePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ArrayOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = false
}

case object `java.List<Point>`
    extends JavaPoint with `box.OneListOfOne` {

  val javaClass = "java.util.List<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("java.awt.Point"))
  val javaDescription = "OneListOfOnePoints"

  def defaultValue = SingleJavaValue("new java.util.ArrayList<java.awt.Point>(0)")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.List<Point>?`
    extends JavaPoint with `box.NullableListOfOne` {

  val javaClass = "java.util.List<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("java.awt.Point"))
  val javaDescription = "NullableListOfOnePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.List<Point?>`
    extends JavaPoint with `box.OneListOfNullable` {

  val javaClass = "java.util.List<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("java.awt.Point"))
  val javaDescription = "OneListOfNullablePoints"

  def defaultValue = SingleJavaValue("new java.util.ArrayList<java.awt.Point>(0)")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.List<Point?>?`
    extends JavaPoint with `box.NullableListOfNullable` {

  val javaClass = "java.util.List<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.List", JavaClass("java.awt.Point"))
  val javaDescription = "NullableListOfNullablePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    ListOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , ListOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Point>`
    extends JavaPoint with `box.OneSetOfOne` {

  val javaClass = "java.util.Set<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("java.awt.Point"))
  val javaDescription = "OneSetOfOnePoints"

  def defaultValue = SingleJavaValue("new java.util.HashSet<java.awt.Point>(0)")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Point>?`
    extends JavaPoint with `box.NullableSetOfOne` {

  val javaClass = "java.util.Set<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("java.awt.Point"))
  val javaDescription = "NullableSetOfOnePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Point?>`
    extends JavaPoint with `box.OneSetOfNullable` {

  val javaClass = "java.util.Set<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("java.awt.Point"))
  val javaDescription = "OneSetOfNullablePoints"

  def defaultValue = SingleJavaValue("new java.util.HashSet<java.awt.Point>(0)")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Set<Point?>?`
    extends JavaPoint with `box.NullableSetOfNullable` {

  val javaClass = "java.util.Set<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Set", JavaClass("java.awt.Point"))
  val javaDescription = "NullableSetOfNullablePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    SetOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , SetOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Queue<Point>`
    extends JavaPoint with `box.OneQueueOfOne` {

  val javaClass = "java.util.Queue<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Queue", JavaClass("java.awt.Point"))
  val javaDescription = "OneQueueOfOnePoints"

  def defaultValue = SingleJavaValue("new java.util.ArrayDeque<java.awt.Point>(0)")

  def nonDefaultValues = IndexedSeq(
    QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Queue<Point>?`
    extends JavaPoint with `box.NullableQueueOfOne` {

  val javaClass = "java.util.Queue<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Queue", JavaClass("java.awt.Point"))
  val javaDescription = "NullableQueueOfOnePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Queue<Point?>`
    extends JavaPoint with `box.OneQueueOfNullable` {

  val javaClass = "java.util.Queue<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Queue", JavaClass("java.awt.Point"))
  val javaDescription = "OneQueueOfNullablePoints"

  def defaultValue = SingleJavaValue("new java.util.ArrayDeque<java.awt.Point>(0)")

  def nonDefaultValues = IndexedSeq(
    QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Queue<Point?>?`
    extends JavaPoint with `box.NullableQueueOfNullable` {

  val javaClass = "java.util.Queue<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Queue", JavaClass("java.awt.Point"))
  val javaDescription = "NullableQueueOfNullablePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , QueueOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.LinkedList<Point>`
    extends JavaPoint with `box.OneLinkedListOfOne` {

  val javaClass = "java.util.LinkedList<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.LinkedList", JavaClass("java.awt.Point"))
  val javaDescription = "OneLinkedListOfOnePoints"

  def defaultValue = SingleJavaValue("new java.util.LinkedList<java.awt.Point>()")

  def nonDefaultValues = IndexedSeq(
    LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.LinkedList<Point>?`
    extends JavaPoint with `box.NullableLinkedListOfOne` {

  val javaClass = "java.util.LinkedList<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.LinkedList", JavaClass("java.awt.Point"))
  val javaDescription = "NullableLinkedListOfOnePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.LinkedList<Point?>`
    extends JavaPoint with `box.OneLinkedListOfNullable` {

  val javaClass = "java.util.LinkedList<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.LinkedList", JavaClass("java.awt.Point"))
  val javaDescription = "OneLinkedListOfNullablePoints"

  def defaultValue = SingleJavaValue("new java.util.LinkedList<java.awt.Point>()")

  def nonDefaultValues = IndexedSeq(
    LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.LinkedList<Point?>?`
    extends JavaPoint with `box.NullableLinkedListOfNullable` {

  val javaClass = "java.util.LinkedList<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.LinkedList", JavaClass("java.awt.Point"))
  val javaDescription = "NullableLinkedListOfNullablePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , LinkedListOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Stack<Point>`
    extends JavaPoint with `box.OneStackOfOne` {

  val javaClass = "java.util.Stack<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Stack", JavaClass("java.awt.Point"))
  val javaDescription = "OneStackOfOnePoints"

  def defaultValue = SingleJavaValue("new java.util.Stack<java.awt.Point>()")

  def nonDefaultValues = IndexedSeq(
    StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Stack<Point>?`
    extends JavaPoint with `box.NullableStackOfOne` {

  val javaClass = "java.util.Stack<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Stack", JavaClass("java.awt.Point"))
  val javaDescription = "NullableStackOfOnePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Stack<Point?>`
    extends JavaPoint with `box.OneStackOfNullable` {

  val javaClass = "java.util.Stack<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Stack", JavaClass("java.awt.Point"))
  val javaDescription = "OneStackOfNullablePoints"

  def defaultValue = SingleJavaValue("new java.util.Stack<java.awt.Point>()")

  def nonDefaultValues = IndexedSeq(
    StackOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Stack<Point?>?`
    extends JavaPoint with `box.NullableStackOfNullable` {

  val javaClass = "java.util.Stack<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Stack", JavaClass("java.awt.Point"))
  val javaDescription = "NullableStackOfNullablePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    StackOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , StackOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Vector<Point>`
    extends JavaPoint with `box.OneVectorOfOne` {

  val javaClass = "java.util.Vector<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Vector", JavaClass("java.awt.Point"))
  val javaDescription = "OneVectorOfOnePoints"

  def defaultValue = SingleJavaValue("new java.util.Vector<java.awt.Point>(0)")

  def nonDefaultValues = IndexedSeq(
    VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Vector<Point>?`
    extends JavaPoint with `box.NullableVectorOfOne` {

  val javaClass = "java.util.Vector<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Vector", JavaClass("java.awt.Point"))
  val javaDescription = "NullableVectorOfOnePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Vector<Point?>`
    extends JavaPoint with `box.OneVectorOfNullable` {

  val javaClass = "java.util.Vector<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Vector", JavaClass("java.awt.Point"))
  val javaDescription = "OneVectorOfNullablePoints"

  def defaultValue = SingleJavaValue("new java.util.Vector<java.awt.Point>(0)")

  def nonDefaultValues = IndexedSeq(
    VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}

case object `java.Vector<Point?>?`
    extends JavaPoint with `box.NullableVectorOfNullable` {

  val javaClass = "java.util.Vector<java.awt.Point>"
  val javaType = JavaCollectionType("java.util.Vector", JavaClass("java.awt.Point"))
  val javaDescription = "NullableVectorOfNullablePoints"

  def defaultValue = SingleJavaValue("null")

  def nonDefaultValues = IndexedSeq(
    VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  , VectorOfJavaValues("java.awt.Point",
      SingleJavaValue("null")
    , SingleJavaValue("new java.awt.Point()")
    , SingleJavaValue("new java.awt.Point(Integer.MIN_VALUE, Integer.MIN_VALUE)")
    , SingleJavaValue("new java.awt.Point(Integer.MAX_VALUE, Integer.MAX_VALUE)")
    , SingleJavaValue("new java.awt.Point(0, -1000000000)")
    , SingleJavaValue("new java.awt.Point(0, 1000000000)")
    )
  )

  val hasGenerics = true
}