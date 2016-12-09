package com.dslplatform.ocd
package staging

import java.net.URL

import org.kohsuke.github.{GHRelease, GitHub}

import scala.reflect.io.ZipArchive

object Fetch {
  private[staging] val releases = repositories / "github-releases"
  private[staging] val `revenj.net library dependencies` = "revenj-core.zip"
  private[staging] val `revenj.net runtime server` = "http-server.zip"

  def apply(includePrereleases: Boolean): Unit = {
    if (releases.exists) {
      logger.trace("Cleaning old github-releases ...")
      releases.deleteRecursively(force = true, continueOnFailure = false)
    }

    def extractAssets(release: GHRelease) =
      release.getAssets.asScala filter { _.getName match {
        case `revenj.net library dependencies`
           | `revenj.net runtime server` => true
        case _ => false
      }}

    val lastRelease = GitHub.connectAnonymously()
      .getRepository("ngs-doo/revenj")
      .listReleases.asScala
      .find { release =>
        val version = release.getTagName
        if (release.isDraft) {
          logger.debug("Skipping draft release: {}", version)
          false
        } else if (release.isPrerelease && !includePrereleases) {
          logger.debug("Skipping prerelease: {}", version)
          false
        } else {
          val found = extractAssets(release).size == 2
          if (found) {
            true
          } else {
            sys.error("Could not find both required bundles in release: " + version)
          }
        }
      }.getOrElse(sys.error("Could not find latest Revenj release!"))

    val version = lastRelease.getTagName
    val assets = extractAssets(lastRelease)

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
