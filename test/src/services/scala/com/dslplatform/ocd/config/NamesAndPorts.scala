package com.dslplatform.ocd
package config

/** A utility class that contains and stores a mapping of generated
  * project names to server ports.
  * On the first run the mappings are persisted in an on-disk .properties file. */
class NamesAndPorts(
    logger: Logger
  , testSettings: ITestSettings) {

  val random = new Random

  // TODO: Move this class into the portCorrector and reference as external library
  val propertiesSourceFile = testSettings.workspace.path / "projectNamesAndPortsRepository.properties"
  var portSequence = 10000 + 1000 * random.nextInt(50)

  private val props = new Properties()
  if (propertiesSourceFile.exists) {
    propertiesSourceFile.inputStream acquireAndGet { props.load }
    for (propName <- props.stringPropertyNames.asScala) {
      if (propName endsWith ".port") {
        val propVal = props.getProperty(propName).toInt
        if (propVal > portSequence) {
          portSequence = propVal
        }
      }
    }
  }

  def generateProjectRevenjPort(projectShortName: String, projectHost: String): Int = {
    props.setProperty(projectShortName + ".host", projectHost);
    if (props.containsKey(projectShortName)) {
      this(projectShortName + ".port")
    } else {
      portSequence += 1
      this(projectShortName + ".port") = portSequence
      portSequence
    }
  }

  def update(projectDatabase: String, port: Int): Unit = {
    props.setProperty(projectDatabase, port.toString)
    this.propertiesSourceFile.outputStream() acquireAndGet {
      props.store(_, "Generated mappings for project names to their server ports.")
    }
  }

  def apply(key: String): Int =
    props.getProperty(key).toInt
}