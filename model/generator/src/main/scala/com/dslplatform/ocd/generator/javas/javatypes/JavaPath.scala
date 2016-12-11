package com.dslplatform.ocd
package generator
package javas
package javatypes

import types._
import boxes._

object JavaPath
    extends JavaStub {

  val classReference = "com.dslplatform.client.TreePath"

  val defaultSingle: TestValue = E"new com.dslplatform.client.TreePath(${""})"

  private[this] val AllowedChars = ('a' to 'z') ++ ('A' to 'Z') ++ ('0' to '9') mkString

  val nonDefaultValues: Seq[TestValue] = Seq(
    E"new com.dslplatform.client.TreePath(${"a"})"
  , E"new com.dslplatform.client.TreePath(${"foo.bar.baz"})"
  , E"new com.dslplatform.client.TreePath(${
      (1 to 4) map (AllowedChars *) mkString "."
    })"
  )
}
