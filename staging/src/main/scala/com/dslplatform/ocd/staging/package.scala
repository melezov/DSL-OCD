package com.dslplatform.ocd

import java.io.FileInputStream
import java.text.NumberFormat
import java.util.Locale

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import scala.concurrent.{Await, ExecutionContext}

package object staging
    extends com.github.nscala_time.time.Imports
    with scala.collection.convert.DecorateAsScala {

  val Path = scalax.file.Path
  type Path = scalax.file.Path

  type Future[T] = scala.concurrent.Future[T]
  val Future = scala.concurrent.Future

  val now = DateTime.now
  val xkcd = now.toString("YYMMdd-HHmmss")

  val logger = Logger(LoggerFactory.getLogger("dsl-ocd-staging"))

  lazy val templates: Path = {
    val properties = new java.util.Properties
    val configPath = sys.props("user.home")
      .replace('\\', '/')
      .replaceFirst("/+$", "") + "/.config/DSL-OCD/ocd.config"
    val fis = new FileInputStream(configPath)
    properties.load(fis)
    fis.close()
    Path(properties.getProperty("templates").replace('\\', '/'), '/').toAbsolute
  }

  val repositories = templates / "staging"
  val userHome = repositories / ".home"

  val pool = java.util.concurrent.Executors.newFixedThreadPool(
    Runtime.getRuntime.availableProcessors())

  implicit val executionContext = ExecutionContext.fromExecutor(pool)

  def block(fs: (() => Unit)*): Unit = {
    val futureSeq = Future.sequence(fs map (f => Future(f())))
    Await.result(futureSeq, scala.concurrent.duration.Duration.Inf)
  }

  def unixVsWindows(unixArgs: String*)(windowsArgs: String*): Seq[String] =
    if (java.io.File.separator == "/") unixArgs else windowsArgs

  def format(number: Long) = {
    val nf = NumberFormat.getInstance(Locale.ROOT)
    nf.format(number)
  }

  def backup(path: Path): Unit = {
    val backup = path.parent.get / (path.name + ".backup")
    if (backup.exists) {
      backup.copyTo(target = path, replaceExisting = true)
    } else {
      path.copyTo(target = backup)
    }
  }
}
