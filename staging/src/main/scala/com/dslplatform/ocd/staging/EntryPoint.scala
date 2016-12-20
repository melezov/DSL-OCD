package com.dslplatform.ocd
package staging

object EntryPoint
    extends App {

  def time[R](section: String, runSection: => Unit): Unit = {
    logger.info(s"### ${section} START ###")
    val startAt = System.currentTimeMillis
    runSection
    val endAt = System.currentTimeMillis
    logger.info(s"### ${section} END (took: ${endAt - startAt} ms) ###")
  }

  val skipSource = args contains "source:skip"
  val skipAnalyse = args contains "analyse:skip"
  val skipCompile = args contains "compile:skip"
  val skipFetch = args contains "fetch:skip"
  val skipDownload = args contains "download:skip"
  val skipUtil = args contains "util:skip"
  val skipModel = args contains "model:skip"
  val skipDrivers = args contains "drivers:skip"
  val skipGather = args contains "gather:skip"
  val skipDeploy = args contains "deploy:skip"
  val skipTest = args contains "test:skip"
  val includePrereleases = args contains "fetch:include-prereleases"

  time("Staging",
    try {
      time("Source", Source(skipSource))
      time("Analyse", Analyse(skipAnalyse))
      time("Compile", Compile(skipCompile))
      time("Fetch", Fetch(skipFetch, includePrereleases))
      time("Download", Download(skipDownload))
      time("Util", Util(skipUtil))
      time("Model", Model(skipModel))
      time("Drivers", Drivers(skipDrivers))
      time("Gather", Gather(skipGather))
      time("Deploy", Deploy(skipDeploy))
//      time("Test", Test(skipTest))
    } finally {
      pool.shutdown()
    }
  )
}
