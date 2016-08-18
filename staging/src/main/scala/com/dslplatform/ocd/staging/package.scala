package com.dslplatform.ocd

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import scala.concurrent.{Await, ExecutionContext}

package object staging
    extends com.github.nscala_time.time.Imports {

  val Path = scalax.file.Path
  type Path = scalax.file.Path

  type Future[T] = scala.concurrent.Future[T]
  val Future = scala.concurrent.Future

  val now = DateTime.now
  val xkcd = now.toString("YYMMdd-HHmmss")

  val logger = Logger(LoggerFactory.getLogger("dsl-ocd-staging"))

  val tools = Path("tools")
  val repositories = Path("repositories") toAbsolute
  val userHome = repositories / ".home"

  implicit val executionContext =
    ExecutionContext.fromExecutor(
      java.util.concurrent.Executors.newFixedThreadPool(
        Runtime.getRuntime.availableProcessors()))

  def block(futures: Future[_]*): Unit = {
    for (future <- futures) {
      Await.result(future, scala.concurrent.duration.Duration.Inf)
    }
  }

  def unixVsWindows(unixArgs: String*)(windowsArgs: String*): Seq[String] =
    if (java.io.File.separator == "/") unixArgs else windowsArgs
}
