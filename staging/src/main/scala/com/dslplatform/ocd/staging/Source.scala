package com.dslplatform.ocd
package staging

import org.eclipse.jgit.api.Git
import org.eclipse.jgit.lib.BatchingProgressMonitor

object Source {
  private[this] def git(username: String, project: String, branch: String): Unit = {
    val target = repositories / project
    if (target.exists) {
      logger.debug("Cleaning existing clone: {}", target.path)
      target.deleteRecursively(force = true, continueOnFailure = false)
    }

    val progressMonitor = new BatchingProgressMonitor {
      private[this] var lastTime = 0L
      def onUpdate(taskName: String, workCurr: Int) = ()
      def onUpdate(taskName: String, workCurr: Int, workTotal: Int, percentDone: Int) = {
        val now = System.currentTimeMillis()
        val show = now - lastTime > 1000
        if (show) lastTime = now
        if (show || percentDone == 100) {
          logger.debug(s"--#  Working GIT @ {}/{}: $taskName ($percentDone%) ...", project, branch)
        }
        logger.trace(s"--#  Working GIT @ {}/{}: $taskName ($percentDone%) [$workCurr/$workTotal] ...", project, branch)
      }
      def onEndTask(taskName: String, workCurr: Int) = ()
      def onEndTask(taskName: String, workCurr: Int, workTotal: Int, percentDone: Int) = ()
    }

    logger.info("--> Starting GIT @ {}/{}", project, branch)
    Git.cloneRepository()
      .setURI(s"https://github.com/$username/$project.git")
      .setBranch(branch)
      .setDirectory(target.fileOption.get)
      .setProgressMonitor(progressMonitor)
      .call()
    logger.info("<-- Finished GIT @ {}/{}", project, branch)
  }

  def apply(skipSource: Boolean): Unit = block(
    () => if (!skipSource) git("dsl-platform", "dsl-json", "master")
  , () => if (!skipSource) git("dsl-platform", "dsl-client-java", "master")
  , () => if (!skipSource) git("dsl-platform", "revenj", "master")
  , () => if (!skipSource) git("dsl-platform", "dsl-compiler-client", "master")
  )
}
