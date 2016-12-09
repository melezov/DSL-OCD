package com.dslplatform.ocd
package staging

import sys.process._

object Source {
  private[this] def git(username: String, project: String, branch: String): Unit = {
    val target = repositories / project
    if (target.exists) {
      logger.trace("Cleaning existing clone: {}", target.path)
      target.deleteRecursively(force = true, continueOnFailure = false)
    }
    logger.debug(">> Starting GIT @ {}/{}", project, branch)
    Seq(
      "git", "clone"
      , "-b", branch
      , "--depth", "1"
      , "--single-branch"
      , s"https://github.com/${username}/${project}.git", target.path
    )! ProcessLogger(logger.trace(_), logger.trace(_))
    logger.debug("<< Finished with GIT @ {}/{}", project, branch)
  }

  def apply(skipGit: Boolean): Unit = block(
    () => if (!skipGit) git("dsl-platform", "dsl-json", "master")
  , () => if (!skipGit) git("dsl-platform", "dsl-client-java", "master")
  , () => if (!skipGit) git("dsl-platform", "revenj", "master")
  , () => if (!skipGit) git("dsl-platform", "dsl-compiler-client", "master")
  )
}
