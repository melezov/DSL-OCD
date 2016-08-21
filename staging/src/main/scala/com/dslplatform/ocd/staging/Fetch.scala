package com.dslplatform.ocd
package staging

import java.net.URL

import org.kohsuke.github.GitHub
import scala.reflect.io.ZipArchive

object Fetch {
  private[this] val releases = repositories / "github-releases"
  private[this] val `revenj.net library dependencies` = "revenj-core.zip"
  private[this] val `revenj.net runtime server` = "http-server.zip"

  def apply(): Unit = {
    val lastRelease = GitHub.connectAnonymously()
      .getRepository("ngs-doo/revenj")
      .listReleases.asScala
      .headOption.getOrElse(sys.error("Could not find latest Revenj release!"))

    val assets = lastRelease.getAssets.asScala filter { _.getName match {
      case `revenj.net library dependencies`
         | `revenj.net runtime server` => true
      case _ => false
    }} ensuring(_.size == 2, "Could not find both required bundles!")

    val version = lastRelease.getTagName
    logger.info("Downloading binary Revenj.NET release from GitHub: {}", lastRelease.getTagName)

    assets.par foreach { asset =>
      val assetUrl = new URL(asset.getBrowserDownloadUrl)
      logger.debug("Downloading {} ...", assetUrl)

      val target = releases / (asset.getName.replaceFirst("\\.zip$", "") + "-" + version)
      if (target.exists) {
        logger.trace("Cleaning previous download: {} ...", target.path)
        target.deleteRecursively(force = true, continueOnFailure = false)
      }

      for (entry <- ZipArchive.fromURL(assetUrl)) {
        logger.trace(s"Extracting {}: {}", asset.getName, entry.name)
        (target / entry.name) write (entry.toByteArray)
      }

      logger.debug("Downloaded and extracted: {}", target.name)
    }
  }
}
