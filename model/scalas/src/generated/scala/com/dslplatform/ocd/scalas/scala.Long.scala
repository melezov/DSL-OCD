package com.dslplatform.ocd
package scalas

import types._
import boxes._

sealed abstract class ScalaLong
    extends OcdScalaBoxType
    with `type.Long`

case object `scala.Long`
    extends ScalaLong with `box.One` {

  val scalaClass = "Long"

  val defaultValue = "0L"
}

case object `scala.Long?`
    extends ScalaLong with `box.Nullable` {

  val scalaClass = "Option[Long]"

  val defaultValue = "None"
}

case object `scala.Long[]`
    extends ScalaLong with `box.OneArrayOfOne` {

  val scalaClass = "Array[Long]"

  val defaultValue = "Array[Long].empty"
}

case object `scala.Long[]?`
    extends ScalaLong with `box.NullableArrayOfOne` {

  val scalaClass = "Option[Array[Long]]"

  val defaultValue = "None"
}

case object `scala.Long?[]`
    extends ScalaLong with `box.OneArrayOfNullable` {

  val scalaClass = "Array[Option[Long]]"

  val defaultValue = "Array[Option[Long]].empty"
}

case object `scala.Long?[]?`
    extends ScalaLong with `box.NullableArrayOfNullable` {

  val scalaClass = "Option[Array[Option[Long]]]"

  val defaultValue = "None"
}

case object `scala.List<Long>`
    extends ScalaLong with `box.OneListOfOne` {

  val scalaClass = "IndexedSeq[Long]"

  val defaultValue = "IndexedSeq[Long].empty"
}

case object `scala.List<Long>?`
    extends ScalaLong with `box.NullableListOfOne` {

  val scalaClass = "Option[IndexedSeq[Long]]"

  val defaultValue = "None"
}

case object `scala.List<Long?>`
    extends ScalaLong with `box.OneListOfNullable` {

  val scalaClass = "IndexedSeq[Option[Long]]"

  val defaultValue = "IndexedSeq[Option[Long]].empty"
}

case object `scala.List<Long?>?`
    extends ScalaLong with `box.NullableListOfNullable` {

  val scalaClass = "Option[IndexedSeq[Option[Long]]]"

  val defaultValue = "None"
}

case object `scala.Set<Long>`
    extends ScalaLong with `box.OneSetOfOne` {

  val scalaClass = "Set[Long]"

  val defaultValue = "Set[Long].empty"
}

case object `scala.Set<Long>?`
    extends ScalaLong with `box.NullableSetOfOne` {

  val scalaClass = "Option[Set[Long]]"

  val defaultValue = "None"
}

case object `scala.Set<Long?>`
    extends ScalaLong with `box.OneSetOfNullable` {

  val scalaClass = "Set[Option[Long]]"

  val defaultValue = "Set[Option[Long]].empty"
}

case object `scala.Set<Long?>?`
    extends ScalaLong with `box.NullableSetOfNullable` {

  val scalaClass = "Option[Set[Option[Long]]]"

  val defaultValue = "None"
}

case object `scala.Queue<Long>`
    extends ScalaLong with `box.OneQueueOfOne` {

  val scalaClass = "Queue[Long]"

  val defaultValue = "Queue[Long].empty"
}

case object `scala.Queue<Long>?`
    extends ScalaLong with `box.NullableQueueOfOne` {

  val scalaClass = "Option[Queue[Long]]"

  val defaultValue = "None"
}

case object `scala.Queue<Long?>`
    extends ScalaLong with `box.OneQueueOfNullable` {

  val scalaClass = "Queue[Option[Long]]"

  val defaultValue = "Queue[Option[Long]].empty"
}

case object `scala.Queue<Long?>?`
    extends ScalaLong with `box.NullableQueueOfNullable` {

  val scalaClass = "Option[Queue[Option[Long]]]"

  val defaultValue = "None"
}

case object `scala.LinkedList<Long>`
    extends ScalaLong with `box.OneLinkedListOfOne` {

  val scalaClass = "LinkedList[Long]"

  val defaultValue = "LinkedList[Long].empty"
}

case object `scala.LinkedList<Long>?`
    extends ScalaLong with `box.NullableLinkedListOfOne` {

  val scalaClass = "Option[LinkedList[Long]]"

  val defaultValue = "None"
}

case object `scala.LinkedList<Long?>`
    extends ScalaLong with `box.OneLinkedListOfNullable` {

  val scalaClass = "LinkedList[Option[Long]]"

  val defaultValue = "LinkedList[Option[Long]].empty"
}

case object `scala.LinkedList<Long?>?`
    extends ScalaLong with `box.NullableLinkedListOfNullable` {

  val scalaClass = "Option[LinkedList[Option[Long]]]"

  val defaultValue = "None"
}

case object `scala.Stack<Long>`
    extends ScalaLong with `box.OneStackOfOne` {

  val scalaClass = "Stack[Long]"

  val defaultValue = "Stack[Long].empty"
}

case object `scala.Stack<Long>?`
    extends ScalaLong with `box.NullableStackOfOne` {

  val scalaClass = "Option[Stack[Long]]"

  val defaultValue = "None"
}

case object `scala.Stack<Long?>`
    extends ScalaLong with `box.OneStackOfNullable` {

  val scalaClass = "Stack[Option[Long]]"

  val defaultValue = "Stack[Option[Long]].empty"
}

case object `scala.Stack<Long?>?`
    extends ScalaLong with `box.NullableStackOfNullable` {

  val scalaClass = "Option[Stack[Option[Long]]]"

  val defaultValue = "None"
}

case object `scala.Vector<Long>`
    extends ScalaLong with `box.OneVectorOfOne` {

  val scalaClass = "Vector[Long]"

  val defaultValue = "Vector[Long].empty"
}

case object `scala.Vector<Long>?`
    extends ScalaLong with `box.NullableVectorOfOne` {

  val scalaClass = "Option[Vector[Long]]"

  val defaultValue = "None"
}

case object `scala.Vector<Long?>`
    extends ScalaLong with `box.OneVectorOfNullable` {

  val scalaClass = "Vector[Option[Long]]"

  val defaultValue = "Vector[Option[Long]].empty"
}

case object `scala.Vector<Long?>?`
    extends ScalaLong with `box.NullableVectorOfNullable` {

  val scalaClass = "Option[Vector[Option[Long]]]"

  val defaultValue = "None"
}