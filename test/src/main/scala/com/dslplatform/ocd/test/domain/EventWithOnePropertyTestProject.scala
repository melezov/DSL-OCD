package com.dslplatform.ocd
package test
package domain

import config._
import dsls._
import javas._
import javatest._
import javatest.property._

private[domain] class EventWithOnePropertySetupFactory(
    testSettings: ITestSettings
  ) extends SetupFactory(testSettings) {

  val setups = for {
    st <- AggregateRootSugar.values
    d <- OcdDslBoxType.useCaseValues(testSettings)
    if !isOracle || (d.typeName != "String" && d.typeName != "Text" && d.typeName != "Binary" || !d.isCollection)
  } yield {
    new EventWithOnePropertySetup(d)
  }
}

private[domain] class EventWithOnePropertySetup(
    val propertyType: OcdDslBoxType
  ) extends TestSetup {

  def ModuleName = "Event" + propertyType.typeNameSafe
  def eventComment = s"EventWith${propertyType.dslDesc}Property"

  def shortName = propertyType.dslDescShort
  def EventName = "E" + shortName
  def propertyName = "p" + shortName
  def PropertyName = propertyName.fciu

  private val dslPath = s"events/${ModuleName}/${EventName}.dsl"

  private val dslBody =
s"""module ${ModuleName}
{
  // ${eventComment}
  event ${EventName} {
    ${propertyType.dslName} ${propertyName};
  }
}
"""

  val dslFiles = Map(dslPath -> dslBody)
}

class EventWithOnePropertyTestProject(
    setup: EventWithOnePropertySetup
  ) extends ITestProject {

  def projectPath = "events/event-single-" + setup.EventName
  def ProjectNameCamel = "EventSingle" + setup.EventName
  def projectName = s"OCD Single Property in Event Tests (${setup.EventName})"

  def dslFiles = setup.dslFiles

  def testFiles = Map(
    JAVA -> Map{
      val javaType = OcdJavaBoxType.resolve(setup.propertyType)
      val template = makeJavaTemplate(javaType)
      val body = template.testBody
      JavaInfo(body).toEntry
    }
  )

  private def makeJavaTemplate(ojbt: OcdJavaBoxType) = new TestJavaTemplate {
    def packageName = "com.dslplatform.ocd.events"
    def testName = setup.eventComment + "Test"

    override def imports = Seq(
      "java.io.IOException"
    , "java.util.concurrent.ExecutionException"
    )

    override def classDecorations: Seq[String] = Nil

    val eventConcept = "ocd." + setup.ModuleName + "." + setup.EventName
    val javaProperty = OcdJavaBoxTypeProperty(setup.propertyName, ojbt)

    override def leadingBlocks = Seq(s"""
    private static org.slf4j.Logger logger;
    private static com.dslplatform.client.JsonSerialization jsonSerialization;
    private static com.dslplatform.client.DomainProxy domainProxy;

    @org.junit.BeforeClass
    public static void initialize() throws IOException {
        final com.dslplatform.patterns.ServiceLocator locator = com.dslplatform.client.Bootstrap.init(
                ${testName}.class.getResourceAsStream("/dsl-project.properties"));
        logger = locator.resolve(org.slf4j.Logger.class);
        jsonSerialization = locator.resolve(com.dslplatform.client.JsonSerialization.class);
        domainProxy = locator.resolve(com.dslplatform.client.DomainProxy.class);
    }
""")

    private val uriProperty = OcdJavaBoxTypeProperty("URI", `java.String`)

    override def tests = Seq(
      new TestJavaPropertyFieldType {
        def conceptName = eventConcept
        def property = uriProperty
        def visibility = Visibility.Private
      }
    , new TestJavaPropertyGetterType {
        def conceptName = eventConcept
        def property = uriProperty
        def visibility = Visibility.Public
      }
    , new TestJavaPropertySetterType {
        def conceptName = eventConcept
        def property = uriProperty
        def visibility = Visibility.Private
        override def testNonExistence = true
      }
    , new TestJavaPropertyFieldType {
        def conceptName = eventConcept
        def property = javaProperty
        def visibility = Visibility.Private
      }
    , new TestJavaPropertyGetterType {
        def conceptName = eventConcept
        def property = javaProperty
        def visibility = Visibility.Public
      }
    , new TestJavaPropertySetterType {
        def conceptName = eventConcept
        def property = javaProperty
        def visibility = Visibility.Public
      }
    , new TestJavaPropertyDefaultValue {
        def conceptName = eventConcept
        def property = javaProperty
      }
    , new TestJavaPropertyInEvent {
        def conceptName = eventConcept
        def property = javaProperty
        def isDefault = true
        def testID = "Default"
        def testValue = ojbt.defaultValue
      }
    ) ++ ojbt.nonDefaultValues.zipWithIndex.map { case (ndv, index) =>
      new TestJavaPropertyInEvent {
        def conceptName = eventConcept
        def property = javaProperty
        def isDefault = false
        def testID = "NonDefault" + (index + 1)
        def testValue = ndv
      }
    }
  }
}

class EventWithOnePropertyTestProjectFactory(
    testSettings: ITestSettings
  ) extends ProjectFactory(testSettings) {

  private lazy val setups = new EventWithOnePropertySetupFactory(testSettings).setups

  def projects =
    (setups.groupBy(_.propertyType.typeNameSafe) map { case (typeNameSafe, typeSetups) =>
      new ITestProject {
        def projectPath = "events/event-single-" + typeNameSafe
        def ProjectNameCamel = "EventSingle" + typeNameSafe
        def projectName = s"OCD Single Property in Event Tests (${typeNameSafe})"
        val dslFiles = typeSetups.dslFiles
        val testFiles = typeSetups.map(new EventWithOnePropertyTestProject(_)).testFiles
      }
    }) toSeq
}
