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
  val skipUtil = args contains "util:skip"
  val skipModel = args contains "model:skip"
  val includePrereleases = args contains "fetch:include-prereleases"

  time("Staging",
    try {
      time("Source", Source(skipSource))
      time("Analyse", Analyse())
      time("Compile", Compile())
      time("Fetch", Fetch(includePrereleases))
      time("Download", Download())
      time("Util", Util(skipUtil))
      time("Model", Model(skipModel))
//      time("Gather", Gather())
//      time("Deploy", Deploy())
    } finally {
      pool.shutdown()
    }
  )
}
