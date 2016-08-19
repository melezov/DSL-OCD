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

  time("Staging",
    try {
      time("Source", Source())
      time("Analyse", Analyse())
      time("Compile", Compile())
      time("Download", Download())
      time("Gather", Gather())
    } finally {
      pool.shutdown()
    }
  )
}
