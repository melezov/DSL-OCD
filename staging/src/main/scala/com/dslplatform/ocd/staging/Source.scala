package com.dslplatform.ocd
package staging

import sys.process._

object Source {
  private[this] def git(username: String, project: String, branch: String): Unit = {
    val target = Path("repositories") / project
    if (target.exists) {
      logger.warn("Cleaning existing clone: {}", target.path)
      target.deleteRecursively(force = true, continueOnFailure = false)
    }
    Seq(
      "git", "clone"
      , "-b", branch
      , "--depth", "1"
      , "--single-branch"
      , s"git@github.com:/${username}/${project}.git", s"repositories/${project}"
    )!;
    logger.info("Cloned: {}", target.path)
  }

  def apply(): Unit = block(
    Future { git("dsl-platform", "dsl-json", "master") }
  , Future { git("dsl-platform", "dsl-client-java", "master") }
  , Future { git("dsl-platform", "revenj", "master") }
  , Future { git("dsl-platform", "dsl-compiler-client", "master") }
  )
}
