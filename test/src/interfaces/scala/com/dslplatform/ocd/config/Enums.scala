package com.dslplatform.ocd.config

import java.util.NoSuchElementException

trait Enum {
  val name = this.toString
}

trait EnumObj[T <: Enum] {
  val values: IndexedSeq[T]
  def enumName = this.getClass.getSimpleName.stripSuffix("$")
  def find(name: String): T = {
    values find(_.name.toLowerCase == name.toLowerCase) getOrElse {
      throw new NoSuchElementException(s"Element named '$name' in enum '$enumName' not found! Available elements: " + values.mkString(", "))
    }
  }
  override def toString = enumName
}

sealed trait Revenj extends Enum {
  val templateName: String
  val configs: Seq[String]
}
object Revenj extends EnumObj[Revenj] {
  case object DotNet extends Revenj {
    val templateName = "revenj.net"
    val configs = Seq("Revenj.Http.exe.config.template")
  }
  case object Java extends Revenj {
    val templateName = "revenj.java"
    val configs = Seq("revenj.properties.template")
  }
  case object Scala extends Revenj {
    val templateName = "revenj.scala"
    val configs = Seq("revenj.properties.template", "application.conf.template")
  }
  val values = IndexedSeq[Revenj](DotNet, Java, Scala)
}

sealed trait Database extends Enum { val templateName: String }
object Database extends EnumObj[Database] {
  case object PostgreSQL extends Database { val templateName = "postgres" }
  case object Oracle32   extends Database { val templateName = "oracle"   }
  case object Oracle64   extends Database { val templateName = "oracle"   }
  val values = IndexedSeq(PostgreSQL, Oracle32, Oracle64)
}
