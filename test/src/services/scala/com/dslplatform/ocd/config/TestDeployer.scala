package com.dslplatform.ocd
package config

import org.apache.commons.io.IOUtils
import test.javatest.{JavaInfo, TestSuiteCreator}

private[config] class TestDeployer(
    logger: Logger
  , testSettings: ITestSettings
  ) extends ITestDeployer {

  private val rootTarget = testSettings.workspace.path

  private val toolsTemplate = testSettings.templates / "tools"
  private val toolsTarget = rootTarget / "tools"

  private val reportTemplate = testSettings.templates / "report"
  private val reportTarget = rootTarget / "report"

  private val masterBuild = testSettings.templates / "master-build"
  private val buildTemplates = testSettings.templates / "build-templates"
  private val projectBuild = testSettings.templates / "project"

  private val serverConfigTemplate = testSettings.templates / "config-templates" / s"revenj.${testSettings.database.templateName}" / s"${testSettings.revenj.configName}"
  private val serverConfigTarget = toolsTarget / "config"

  private val commonBuildTemplateName = s"build-common-template-${testSettings.revenj.templateName}-${testSettings.database.templateName}.xml"

  private val testResourcesTemplate = testSettings.templates / "test-resources"


  def deployTests(tests: Seq[ITestProject]): Unit = {
    logger.trace(s"Deploying ${tests.size} tests ...")

    val namesAndPorts = new NamesAndPorts(logger, testSettings)
    copyStatic()

    tests/* .par*/ foreach { test =>
      new TestSetup(test, namesAndPorts).deploy()
    }
  }

  /** Copy the static tools resources common to all generated projects to the target directory */
  private[this] def copyStatic(): Unit = {
    logger.debug("Copying the static tools and resources ...")

    cleanAndCopy(masterBuild, rootTarget)
    cleanAndCopy(buildTemplates / commonBuildTemplateName, rootTarget / "build-common-template.xml")
    cleanAndCopy(toolsTemplate, toolsTarget)
    cleanAndCopy(reportTemplate, reportTarget)
    cleanAndCopy(serverConfigTemplate, serverConfigTarget / serverConfigTemplate.name)
  }

  private def cleanAndCopy(source: Path, target: Path): Unit = {
    if(target.exists) {
      logger.trace("Cleaning target path: " + target.path)
      target.deleteRecursively(true, true)
    }
    logger.trace(s"Copying ${source.path} to ${target.path}")
    source copyTo target
  }

  class TestSetup(testProject: ITestProject, namesAndPorts: NamesAndPorts) {
    private val projectRoot = rootTarget / (testProject.projectPath, '/')
    private val projectShortName = testProject.projectPath.replaceAll(".*/", "")

    private val dslTarget = projectRoot / "dsl"

    private def languageRoot(language: Language) =
      projectRoot / language.language.toLowerCase.concat("_project")

    private def mainRoot(language: Language) =
      languageRoot(language) / "src" / "main"

    private def mainCode(language: Language) =
      mainRoot(language) / language.language.toLowerCase()

    private def mainResources(language: Language) =
      mainRoot(language) / "resources"

    private def generatedRoot(language: Language) =
      languageRoot(language) / "src" / "generated"

    private def generatedCode(language: Language) =
      generatedRoot(language) / language.language.toLowerCase()

    private def generatedResources(language: Language) =
      generatedRoot(language) / "resources"

    private def testRoot(language: Language) =
      languageRoot(language) / "src" / "test"

    private def testResources(language: Language) =
      testRoot(language) / "resources"

    def deploy(): Unit = {
      logger.trace("Deploying {} ...", testProject.projectName)
      deployDsl()
      prepareGeneratedCodePath()
      deployTestCases()
      deployProjectFiles()
      logger.debug("Deployed {}", testProject.projectName)
    }

    private def deployDsl(): Unit = {
      logger.trace("Cleaning generated DSL: " + dslTarget.path)
      val remaining = dslTarget.deleteRecursively(true, true)._2
      if (remaining > 0) {
        logger.warn(s"Could not delete all generated DSL ($remaining)!")
      }
      val dsls = testProject.dslFiles
      if (dsls.nonEmpty) {
        logger.debug("Deploying {} DSL files to {}", dsls.size, dslTarget)
        dsls.par foreach { case (filename, body) =>
          val path = dslTarget / (filename, '/')
          logger.trace("Deploying DSL: " + path.path)
          path.write(body)
        }
      }
      logger.trace("Done deploying DSL files!")
    }

    private def prepareGeneratedCodePath(): Unit = {
      logger.trace("Preparing the generated code paths ...")

      testProject.testFiles foreach { case (language, files) =>
        val generatedRoot = generatedCode(language)
        if (!generatedRoot.exists) {
          logger.trace("Creating the generated path: " + generatedRoot.path)
          generatedRoot.createDirectory(true, false)
        }

        val resourcePath = generatedResources(language)
        if (!resourcePath.exists) {
          logger.trace("Creating the generated resource path: " + resourcePath.path)
          resourcePath.createDirectory(true, false)
        }
      }

      testProject.testFiles foreach { case (language, files) =>
        val mainRoot = mainCode(language)
        if (!mainRoot.exists) {
          logger.trace("Creating the main path: " + mainRoot.path)
          mainRoot.createDirectory(true, false)
        }

        val resourcePath = mainResources(language)
        if (!resourcePath.exists) {
          logger.trace("Creating the main resource path: " + resourcePath.path)
          resourcePath.createDirectory(true, false)
        }
      }

      logger.trace("Done preparing the generated code paths!")
    }

    private def deployTestCases(): Unit = {
      logger.trace("Cleaning tests ...")
      val languages = testProject.testFiles.keys.toSet

      languages foreach { language =>
        val path = testRoot(language)
        logger.trace(s"Cleaning ($language) tests: " + path.path)

        val remaining = path.deleteRecursively(true, true)._2
        if (remaining > 0) {
          logger.warn(s"Could not delete all code for $language (remaining: $remaining)!")
        }
      }

      logger.trace("Deploying tests...")
      testProject.testFiles foreach { case (language, files) =>
        val testRootForLanguage = testRoot(language)

        val classes = files.values.map(JavaInfo(_).classPath).toIndexedSeq.sorted
        val suite = JavaInfo(
          new TestSuiteCreator {
            def packageName = "com.dslplatform.ocd.test"
            def testName = testProject.ProjectNameCamel
            def testClasses = classes
          } testBody
        )

        val suiteWithTests = files + suite.toEntry

        suiteWithTests.par foreach { case (filename, body) =>
          val path = testRootForLanguage / (filename, '/')
          logger.trace("Deploying test: " + path.path)
          path.write(Patches.fixTests(body))
        }

        cleanAndCopy(testResourcesTemplate, testResources(language))
      }
    }

    private def deployProjectFiles(): Unit =
      testProject.testFiles.keys foreach { case language =>
        logger.trace("Deploying compiler scripts for language: " + language)
        val langRoot = languageRoot(language)
        language match {
          case JAVA =>
            copyTemplate(projectBuild / "build.xml", langRoot / "build.xml")
            copyTemplate(projectBuild / ".pgpass", langRoot / ".pgpass")
            copyTemplate(projectBuild / ".gitignore", langRoot / ".gitignore")
            copyTemplate(projectBuild / ".project", langRoot / ".project")
            copyTemplate(projectBuild / ".classpath", langRoot / ".classpath", jarExpansion)
          case _ =>
        }
      }

    private def copyTemplate(source: Path, target: Path, process: String => String = templateApplication) = {
      logger.trace("Creating the " + source.name + " script: " + target.path)
      val body = process(source.string)
      target write body
    }

    private val projectParamTemplates = Map(
      "projectName" -> testProject.projectName
    , "ProjectNameCamel" -> testProject.ProjectNameCamel
    , "projectShortName" -> projectShortName
    , "javaRoot" -> languageRoot(JAVA).path
    , "dbName" -> projectShortName
    , "dbHost" -> "localhost"
    , "dbPort" -> "5432"
    , "dbUser" -> "ocduser"
    , "dbPassword" -> "ocdpassword"
    , "dbOwner" -> "postgres"
    , "dbOwnerPassword" -> "ocdpassword"
    , "serverHost" -> "127.0.0.1" // "[::1]"
    , "serverPort" -> namesAndPorts.generateProjectRevenjPort(projectShortName, "127.0.0.1").toString()
    , "toolsPath" -> (testSettings.workspace.path.path.replace('\\', '/') + "/tools")
    , "dslSource" -> dslTarget.path
    , "revenjPath" -> serverConfigTarget.path
    )

    private val templateApplication = (stringWithTemplateProperties: String) =>
      (projectParamTemplates :\ stringWithTemplateProperties) { case ((name, value), retVal) => retVal
        .replace("#{" + name + ":escape}", value.replaceAll("([#!:=])", "\\\\$1"))
        .replace("#{" + name + "}", value)
      }

    private val JarExpansionPattern = """(.*?path=")(.*)/\*\*\.jar(".*)""".r
    private val jarExpansion = (classpathWithTemplateProperties: String) => {
      val expanded = (classpathWithTemplateProperties.split("\n") map {
        case JarExpansionPattern(before, path, after) =>
          val src = if (path == "#{toolsPath}/lib") "lib" else path
          ((toolsTemplate / Path.fromString(src) ** "*.jar").toSeq map { jar =>
            before + path + '/' + jar.name + after
          }).sorted.mkString("\n")
        case line =>
          line
      }).mkString("\n")

      templateApplication(expanded)
    }
  }
}