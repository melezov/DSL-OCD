package com.dslplatform.ocd

import dsls.OcdDslBoxType
import scala.concurrent.Future
import config._
import test.javatest.property.turtle._
import test.domain._

object EntryPoint extends App {
  Locator[EntryPoint].run()
}

class EntryPoint(
    logger: Logger
  , testSettings: ITestSettings
  , testDeployer: ITestDeployer) {

  def run(): Unit = {
    Future {
      logger.trace(s"Initializing DSL values ...")
      val values = OcdDslBoxType.values
      logger.debug(s"Initialized ${values.size} DSL values!")
    }

    val turtles = Seq[ITestProject](
      TestJavaAssertsBorderValuesTurtle
    , TestJavaPropertyFieldTypeTurtle
    , TestJavaPropertyGetterTypeTurtle
    , TestJavaPropertySetterTypeTurtle
    )

    val projects = Seq[ProjectFactory](
      new AggregateWithOnePropertyTestProjectFactory(testSettings)
    , new AggregateWithSurrogateKeyAndOnePropertyTestProjectFactory(testSettings)
    , new AggregateWithSurrogateKeyAndOnePropertyWithinOneEntityTestProjectFactory(testSettings)
    , new AggregateWithSurrogateKeyAndOnePropertyWithinOneValueTestProjectFactory(testSettings)
    , new AggregateWithSurrogateKeyAndOnePropertyWithinOneEntityWithinOneEntityTestProjectFactory(testSettings)
    , new AggregateWithSurrogateKeyAndOnePropertyWithinOneValueWithinOneEntityTestProjectFactory(testSettings)
    , new AggregateWithSurrogateKeyAndOnePropertyWithinOneValueWithinOneValueTestProjectFactory(testSettings)
    , new CalculatedPropertyInSnowflakeTestProjectFactory(testSettings)
    , new ValueWithOnePropertyTestProjectFactory(testSettings)
    )

    val tests = projects.flatMap(_.projects)
    logger.info(s"Initialized ${projects.size} project factories, deploying ${tests.size} projects ...")

    testDeployer.deployTests(
      turtles ++
      tests
    )

    logger.info("Finished!")
    sys.exit(0)
  }
}
