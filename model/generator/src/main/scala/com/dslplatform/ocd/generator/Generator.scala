package com.dslplatform.ocd
package generator

import scalax.file._
import java.util.Properties

trait Generator {
  private def readPath(path: String): Path =
    Path(path.replace('\\', '/'), '/')

  private val props = {
    val tmp = new Properties()
    val config = readPath(sys.props("user.home")) /
      ".config" / "DSL-OCD" / "ocd.config"
    config.inputStream acquireAndGet { tmp.load }
    tmp
  }

  private val generated = props.getProperty("model")

  private def gene(name: String, language: String) = readPath(generated) /
    name / "src" / "generated" / language / "com" / "dslplatform" / "ocd"

  def spawnDirectory(name: String, language: String) = {
    val pack = name.replaceAll("-", "")
    val root = gene(name, language) / pack

    if (root.isDirectory) {
      println(s"Cleaning directory: ${root.path} ...")
      root.*** foreach(_.delete(true))
    }
    else {
      println(s"Creating directory: ${root.path} ...")
      root.createDirectory(true, true)
    }

    root
  }

  def generate(): Unit
}
