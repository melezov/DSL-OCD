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

  val skipGit = args contains "skip-git"
  val includePrereleases = args contains "include-prereleases"

  time("Staging",
    try {
      time("Source", Source(skipGit))
      time("Analyse", Analyse())
      time("Compile", Compile())
      time("Fetch", Fetch(includePrereleases))
      time("Download", Download())
      time("Gather", Gather())
      time("Deploy", Deploy())
    } finally {
      pool.shutdown()
    }
  )
}
