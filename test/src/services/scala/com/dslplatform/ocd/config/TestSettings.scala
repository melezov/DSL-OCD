package com.dslplatform.ocd
package config

private[config] class TestSettings(logger: Logger) {
  def load(relativePath: String) = {
    val testIni = Path(
      sys.props("user.home")
        .replace('\\', '/')
        .replaceFirst("\\+$", "") + "/.config/" + relativePath
    , '/'
    )

    logger.info("Loading test settings from: " + testIni.path)

    val properties =
      testIni.inputStream acquireAndGet { is =>
        val props = new Properties
        props load is
        props
      }

    def fromPath(path: String): Path = Path(new java.io.File(path).getAbsoluteFile)

    val settings = new ITestSettings {
      val xkcd = XKCD.now
      logger.debug("Test XKCD: " + xkcd)

      val workspace = {
        val tmp = properties getProperty "test-projects"
        require(tmp ne null, "Workspace could not be read!")
        val path = fromPath(tmp)
        logger.debug("Read test workspace path: " + path.path)
        Workspace(path)
      }

      val templates = {
        val tmp = properties getProperty "templates"
        tmp match {
          case null =>
            val path = workspace / ".." / "templates" path;
            logger.warn("Templates path is not defined, deriving from workspace: " + path.path)
            path
          case path =>
            logger.debug("Read templates path: " + path)
            fromPath(path)
        }
      }

      val revenj = Revenj.find(properties getProperty "targetRevenj")
      logger.debug("Target Revenj: " + revenj)

      val database = Database.find(properties getProperty "targetDatabase")
      logger.debug("Target Database: " + database)
    }

    logger.trace("Test settings successfully extracted!")
    settings
  }
}
