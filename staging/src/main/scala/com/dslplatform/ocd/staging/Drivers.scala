package com.dslplatform.ocd.staging

import scalax.io.Resource

object Drivers {
  private[this] val home = repositories / "drivers"

  private[this] def clean(): Unit = {
    if (home.isDirectory) {
      logger.debug("Cleaning drivers home: {} ...", home.path)
      home.deleteRecursively(force = true, continueOnFailure = true)
    }
  }

  private[this] def postgresqlJdbc(): Unit = {
    val web = "https://jdbc.postgresql.org/"
    val body = Resource.fromURL(web).string
    val pattern = """<h1.*PostgreSQL JDBC Driver ([-\.\d]+) Released!</h1>""".r

    val lastRelease = pattern.findFirstMatchIn(body)
      .getOrElse(sys.error("Could not figure out the last PostgreSQL JDBC release"))
      .group(1)

    logger.info("Latest PostgreSQL JDBC version: {}", lastRelease)

    val versions = Map(
      "JDBC 4  - JRE 6" -> ".jre6"
    , "JDBC 41 - JRE 7" -> ".jre7"
    , "JDBC 42 - JRE 8" -> ""
    )

    for ((desc, suffix) <- versions.par) {
      val standardisedReleaseName = s"postgresql-${lastRelease.replace('-', '.')}${suffix}.jar"
      val url = s"${web}download/$standardisedReleaseName"
      val target = home / "postgresql-jdbc" / standardisedReleaseName
      logger.trace("Downloading {} @ {} ...", desc, url)
      Resource.fromURL(url).copyDataTo(target)
      logger.debug("Downloaded {} to {}", desc, target.path)
    }
  }

  private[this] def oracleJdbc(): Unit = {
    // https://blogs.oracle.com/dev2dev/entry/how_to_get_oracle_jdbc
  }

  def apply(skipDrivers: Boolean): Unit = if (!skipDrivers) {
    clean()
    block(
      () => postgresqlJdbc()
    , () => oracleJdbc()
    )
  }
}
