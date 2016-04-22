package com.dslplatform.ocd
package config

import test.javatest.{JavaInfo, TestSuiteCreator}

private[config] class TestDeployer(
    logger: Logger
  , testSettings: ITestSettings
  ) extends ITestDeployer {

  private val root = testSettings.workspace.path

  private val toolsPath = root / "tools"
  private val configPath = toolsPath / "config"

  def deployTests(tests: Seq[ITestProject]): Unit = {
    logger.trace(s"Deploying ${tests.size} tests ...")
    val namesAndPorts = new NamesAndPorts(logger, testSettings)
    copyStatic()
    tests.par foreach (new TestSetup(_, namesAndPorts).deploy())
  }

  /** Copy the static tools resources common to all generated projects to the target directory */
  private[this] def copyStatic(): Unit = {
    logger.debug("Copying the static tools and resources ...")

    logger.trace("Copying the tools ...")
    if (toolsPath.exists) {
      logger.trace("Cleaning previous tools ...")
      toolsPath.deleteRecursively(true, true)
    }
    testSettings.templates / "tools" copyTo toolsPath
    logger.trace("Finished copying tools!")

//    if (!configTargetPath.exists) {
//      logger.trace("Creating the config target path: " + configTargetPath.path)
//      configTargetPath.createDirectory(true, false)
//    }
////    copyPath(templateToolsPath.jfile.toPath, toolsTargetDir.toPath)
//
//    logger.trace("Copying the master build.xml...")
//    val masterReportBuilder = new java.io.File(classOf[TestDeployer].getResource("/template.master-build.xml").toURI)
//    val masterReportBuilderTarget = new java.io.File((root / "build.xml").toURI)
//    copyPath(masterReportBuilder.toPath, masterReportBuilderTarget.toPath)
//
//    logger.trace("Copying the macrodef.xml...")
//    val macrodef = new java.io.File(classOf[TestDeployer].getResource("/template.macrodef.xml").toURI)
//    val macrodefTarget = new java.io.File((root / "macrodef.xml").toURI)
//    copyPath(macrodef.toPath, macrodefTarget.toPath)
//
//    logger.trace("Copying the common build template...")
//    val commonBuildTemplateName = s"/template.build-common-template-${testSettings.revenj.templateName}-${testSettings.database.templateName}.xml"
//    val commonTemplate = new java.io.File(classOf[TestDeployer].getResource(commonBuildTemplateName).toURI)
//    val commonTemplateTarget = new java.io.File((root / "build-common-template.xml").toURI)
//    copyPath(commonTemplate.toPath, commonTemplateTarget.toPath)
//
//    logger.trace("Copying the Revenj configuration template...")
//    val revenjConfigTemplate = new java.io.File(classOf[TestDeployer].getResource(s"/template.revenj.${testSettings.database.templateName}/${testSettings.revenj.configName}").toURI)
//    val revenjConfigTemplateTarget = new java.io.File((configTargetPath / testSettings.revenj.configName).toURI)
//    copyPath(revenjConfigTemplate.toPath, revenjConfigTemplateTarget.toPath)
  }

  class TestSetup(testProject: ITestProject, namesAndPorts: NamesAndPorts) {

    private val projectRoot = root / (testProject.projectPath, '/')
//    private val libPath = root / "tools" / "java" / "lib"

//    private val projectShortName = testProject.projectPath.replaceAll(".*/", "")

//    private val revenjConfigTemplateTargetPath = toolsTargetPath / "config"

    def deploy(): Unit = {
      logger.trace("Deploying {} ...", testProject.projectName)

//      cleanDsl()
//      cleanTests()
//
      deployDsl()
//      deployGenerated()
//      deployMain()
//      deployTests()
//
//      deployCompilerScript()
//      deployEclipseProject()

      logger.debug("Deployed {}", testProject.projectName)
    }

    private val dslSource = projectRoot / "dsl"

    private def deployDsl(): Unit = {
      val dsls = testProject.dslFiles
      if (dsls.nonEmpty) {
        logger.debug("Deploying {} DSL files to {}", dsls.size, dslSource)

        //      // ugly hack to make turtles compile (doesn't work with empty DSL)
        //      val patchDsls = if (dsls.nonEmpty) dsls
        //      else {
        //        Map("placeholder.dsl" -> placeholder)
        //      }

        dsls.par foreach { case (filename, body) =>
          val path = dslSource /(filename, '/')
          logger.trace("Deploying DSL: " + path.path)
          path.write(body)
        }
      }
    }
  }
}

//  private val templateToolsPath =
//    Path(new java.io.File(classOf[TestDeployer].getResource("/template.tools").toURI))
//
//  if (!root.exists) {
//    logger.trace("Creating the root target path: " + root.path)
//    root.createDirectory(true, false)
//  }
//
//  class TestSetup(testProject: ITestProject, projectNamesAndPortsRepository: ProjectNamesAndPortsRepository) {
//    private val projectRoot = root /(testProject.projectPath, '/')
//    private val libPath = root / "tools" / "java" / "lib"
//
//    private val projectShortName = testProject.projectPath.replaceAll(".*/", "")
//
//    private val revenjConfigTemplateTargetPath = toolsTargetPath / "config"
//    private val dslSource = projectRoot / "dsl"
//
//    private val DSL_PROJECT_INI = "dsl-project.ini"
//
//    private def languageProjectRoot(language: Language) =
//      projectRoot / language.language.toLowerCase.concat("_project")
//
//    private def mainRoot(language: Language) =
//      languageProjectRoot(language) / "src" / "main"
//
//    private def mainCode(language: Language) =
//      mainRoot(language) / language.language.toLowerCase()
//
//    private def mainResources(language: Language) =
//      mainRoot(language) / "resources"
//
//    private def generatedRoot(language: Language) =
//      languageProjectRoot(language) / "src" / "generated"
//
//    private def generatedCode(language: Language) =
//      generatedRoot(language) / language.language.toLowerCase()
//
//    private def generatedResources(language: Language) =
//      generatedRoot(language) / "resources"
//
//    private def testRoot(language: Language) =
//      languageProjectRoot(language) / "src" / "test"
//
//    private def testResources(language: Language) =
//      testRoot(language) / "resources"
//
//    private def cleanDsl(): Unit = {
//      logger.trace("Cleaning generated DSL: " + dslSource.path)
//
//      val remaining = dslSource.deleteRecursively(true, true)._2
//      if (remaining > 0) {
//        logger.warn(s"Could not delete all generated DSL ($remaining)!")
//      }
//    }
//
//    private val placeholder = IOUtils.toString(
//      classOf[TestDeployer].getResourceAsStream("/placeholder.dsl"))
//
//    private def deployGenerated(): Unit =
//      logger.trace("Deploying generated files...")
//
//    testProject.testFiles foreach { case (language, files) =>
//      val generatedRoot = generatedCode(language)
//      if (!generatedRoot.exists) {
//        logger.trace("Creating the generated path: " + generatedRoot.path)
//        generatedRoot.createDirectory(true, false)
//      }
//
//      val resourcePath = generatedResources(language)
//      if (!resourcePath.exists) {
//        logger.trace("Creating the generated resource path: " + resourcePath.path)
//        resourcePath.createDirectory(true, false)
//      }
//    }
//
//    private def deployMain(): Unit =
//      logger.trace("Deploying main code...")
//
//    testProject.testFiles foreach { case (language, files) =>
//      val mainRoot = mainCode(language)
//      if (!mainRoot.exists) {
//        logger.trace("Creating the main path: " + mainRoot.path)
//        mainRoot.createDirectory(true, false)
//      }
//
//      val resourcePath = mainResources(language)
//      if (!resourcePath.exists) {
//        logger.trace("Creating the main resource path: " + resourcePath.path)
//        resourcePath.createDirectory(true, false)
//      }
//    }
//
//    private def cleanTests(): Unit = {
//      logger.trace("Cleaning tests...")
//      val languages = testProject.testFiles.keys.toSet
//
//      languages foreach { language =>
//        val path = testRoot(language)
//        logger.trace(s"Cleaning tests ($language): " + path.path)
//
//        val remaining = path.deleteRecursively(true, true)._2
//        if (remaining > 0) {
//          logger.warn(s"Could not delete all code for $language ($remaining)!")
//        }
//      }
//    }
//
//    private def deployTests(): Unit = {
//      logger.trace("Deploying tests...")
//      testProject.testFiles foreach { case (language, files) =>
//        val languageRoot = testRoot(language)
//
//        val classes = files.values.map(JavaInfo(_).classPath).toIndexedSeq.sorted
//        val suite = JavaInfo(
//          new TestSuiteCreator {
//            def packageName = "com.dslplatform.ocd.test"
//
//            def testName = testProject.ProjectNameCamel
//
//            def testClasses = classes
//          } testBody
//        )
//
//        val suiteWithTests = files + suite.toEntry
//
//        suiteWithTests.par foreach { case (filename, body) =>
//          val path = languageRoot /(filename, '/')
//          logger.trace("Deploying test: " + path.path)
//          path.write(Patches.fixTests(body))
//        }
//
//        val resourcePath = testResources(language)
//        logger.trace("Creating the test resource path: " + resourcePath.path)
//        resourcePath.createDirectory(true, false)
//
//      {
//        val resourceLogback = resourcePath / "logback-test.xml"
//        logger.trace("Writing logback-test.xml: " + resourceLogback.path)
//        val logbackBody = applyTemplates(IOUtils.toString(
//          classOf[TestDeployer].getResourceAsStream("/template.logback-test.xml")))
//        resourceLogback.write(logbackBody)
//      }
//      {
//        val resourceDslProjectIni = testResources(language) / DSL_PROJECT_INI
//        logger.trace(s"Writing $DSL_PROJECT_INI: " + resourceDslProjectIni.path)
//        val dslProjectIniBody = applyTemplates(IOUtils.toString(
//          classOf[TestDeployer].getResourceAsStream(s"/template.$DSL_PROJECT_INI")));
//        resourceDslProjectIni.write(dslProjectIniBody)
//      }
//      }
//    }
//
//    private def deployCompilerScript(): Unit =
//      testProject.testFiles.keys foreach { case language =>
//        logger.trace("Deploying compiler scripts for language: " + language)
//        val languageRoot = languageProjectRoot(language)
//        language match {
//          case JAVA =>
//            copyTemplate("build.xml", languageRoot);
//            copyTemplate(".pgpass", languageRoot);
//          case _ =>
//        }
//      }
//
//    private def copyTemplate(scriptName: String, target: Path, permissions: PosixFilePermission*) = {
//      logger.trace("Copying templates...")
//      val path = target / scriptName
//      logger.trace("Creating the " + scriptName + " script: " + path.path)
//
//      val body = applyTemplates(IOUtils.toString(
//        classOf[TestDeployer].getResourceAsStream("/template." + scriptName)))
//      path.write(body)
//
//      if (!SystemUtils.IS_OS_WINDOWS) {
//        val javaPath = java.nio.file.Paths.get(path.toURI)
//        val perms = Files.getPosixFilePermissions(javaPath)
//        for (permission <- permissions) {
//          perms.add(permission)
//        }
//        Files.setPosixFilePermissions(javaPath, perms)
//      }
//    }
//
//    private val JarExpansion = """(.*?path=")(.*)/\*\*\.jar(".*)""".r
//
//    private def deployEclipseProject(): Unit = {
//      logger.trace("Deploying the eclipse project...")
//      testProject.testFiles.keys foreach { case language =>
//        val languageRoot = languageProjectRoot(language)
//
//        language match {
//          case JAVA =>
//            val gitignorePath = languageRoot / ".gitignore"
//            logger.trace("Creating .gitignore file: " + gitignorePath.path)
//            val gitignore = Path(new java.io.File(classOf[TestDeployer].getResource("/template..gitignore").toURI))
//            gitignore.copyTo(target = gitignorePath, replaceExisting = true)
//
//            val projectPath = languageRoot / ".project"
//            logger.trace("Creating Eclipse .project file: " + projectPath.path)
//            val projectBody = applyTemplates(IOUtils.toString(
//              classOf[TestDeployer].getResourceAsStream("/template.project"), "UTF-8"))
//            projectPath.write(projectBody)
//
//            val classpathPath = languageRoot / ".classpath"
//            logger.trace("Creating Eclipse .classpath file: " + classpathPath.path)
//            val classpathBody = IOUtils.toString(
//              classOf[TestDeployer].getResourceAsStream("/template.classpath"), "UTF-8")
//            val classpathBodyExpandedJars =
//              (classpathBody.split("\n") map {
//                case JarExpansion(before, path, after) =>
//                  val src = if (path == "#{toolsPath}/lib") "lib" else path
//                  ((templateToolsPath / Path.fromString(src) ** "*.jar").toSeq map { jar =>
//                    before + path + '/' + jar.name + after
//                  }).sorted.mkString("\n")
//
//                case line =>
//                  line
//              }
//                ).mkString("\n")
//            classpathPath.write(applyTemplates(classpathBodyExpandedJars))
//
//          case _ =>
//        }
//      }
//    }
//
//    private val projectParamTemplates = Map(
//      "libPath" -> libPath.path
//      , "projectRoot" -> projectRoot.path
//      , "projectName" -> testProject.projectName
//      , "ProjectNameCamel" -> testProject.ProjectNameCamel
//      , "projectShortName" -> projectShortName
//      , "javaRoot" -> languageProjectRoot(JAVA).path
//      , "dbName" -> projectShortName
//      , "dbHost" -> "localhost"
//      , "dbPort" -> "5432"
//      , "dbUser" -> "ocduser"
//      , "dbPassword" -> "ocdpassword"
//      , "dbOwner" -> "postgres"
//      , "dbOwnerPassword" -> "ocdpassword"
//      , "serverHost" -> "127.0.0.1" // "[::1]"
//      , "serverPort" -> projectNamesAndPortsRepository.generateProjectRevenjPort(projectShortName, "127.0.0.1").toString()
//      , "toolsPath" -> (testSettings.workspace.path.path.replace('\\', '/') + "/tools")
//      , "dslSource" -> dslSource.path
//      , "revenjPath" -> revenjConfigTemplateTargetPath.path
//    )
//
//    private def applyTemplates(stringWithTemplateProperties: String): String =
//      (projectParamTemplates :\ stringWithTemplateProperties) { case ((name, value), retVal) => retVal
//        .replace("#{" + name + ":escape}", value.replaceAll("([#!:=])", "\\\\$1"))
//        .replace("#{" + name + "}", value)
//      }
//  }
//
