package com.dslplatform.ocd
package test
package domain

import config._
import types._
import boxes._
import dsls._
import javas._
import javatest._
import javatest.property._

private[domain] class EventWithOnePropertyWithinOneValueSetupFactory(
    testSettings: ITestSettings
  ) extends SetupFactory(testSettings) {

  val setups = for {
    t <- OcdType.useCaseValues(testSettings)
    b <- OcdBox.values
    if !(b.collectionFamily == Some(CollectionFamily.Queue) && b.areElementsNullable == Some(true)) // Queue cannot contain null elements
    if !isOracle || (t.typeName != "String" && t.typeName != "Text" && t.typeName != "Binary" || !b.isCollection)
    d = OcdDslBoxType.resolve(t, b)
  } yield {
    new EventWithOnePropertyWithinOneValueSetup(d)
  }
}

private[domain] class EventWithOnePropertyWithinOneValueSetup(
    val propertyType: OcdDslBoxType
  ) extends TestSetup {

  def ModuleName = "EventOneValue" + propertyType.typeNameSafe
  def eventComment = s"EventWith${propertyType.dslDesc}PropertyWithinOneValue"

  def shortName = propertyType.dslDescShort
  def EventName = "E" + shortName
  def ValueName = "V" + shortName
  def valueName = ValueName.fcil
  def propertyName = "p" + shortName
  def PropertyName = propertyName.fciu

  private val dslPath = s"events/${ModuleName}/${EventName}.dsl"

  private val dslBody =
s"""module ${ModuleName}
{
  // ${eventComment}
  event ${EventName} {
    ${ValueName} ${valueName};
  }

  // should merge with twins
  value ${ValueName} {
    ${propertyType.dslName} ${propertyName};
  }
}
"""

  val dslFiles = Map(dslPath -> dslBody)
}

class EventWithOnePropertyWithinOneValueTestProject(
    setup: EventWithOnePropertyWithinOneValueSetup
  ) extends ITestProject {

  def projectPath = "events/event-single-" + setup.EventName
  def ProjectNameCamel = "EventSingle" + setup.EventName
  def projectName = s"OCD Single Property Within One Value in Event Tests (${setup.EventName})"

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
    val valueConcept = "ocd." + setup.ModuleName + "." + setup.ValueName
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
    , new TestJavaOneValueInEvent {
        def conceptName = eventConcept
        def property = javaProperty
        def isDefault = true
        def testID = "Default"
        def testValue = ojbt.defaultValue
        def valueName = setup.valueName
        def valueConceptName = valueConcept
      }
    ) ++ ojbt.nonDefaultValues.zipWithIndex.map { case (ndv, index) =>
      new TestJavaOneValueInEvent {
        def conceptName = eventConcept
        def property = javaProperty
        def isDefault = false
        def testID = "NonDefault" + (index + 1)
        def testValue = ndv
        def valueName = setup.valueName
        def valueConceptName = valueConcept
      }
    }
  }
}

class EventWithOnePropertyWithinOneValueTestProjectFactory(
    testSettings: ITestSettings
  ) extends ProjectFactory(testSettings) {

  private lazy val setups = new EventWithOnePropertyWithinOneValueSetupFactory(testSettings).setups

  def projects =
    (setups.groupBy(_.propertyType.typeNameSafe) map { case (typeNameSafe, typeSetups) =>
      new ITestProject {
        def projectPath = "events/event-one-value-" + typeNameSafe
        def ProjectNameCamel = "EventOneValue" + typeNameSafe
        def projectName = s"OCD Single Property Within One Value in Event Tests (${typeNameSafe})"
        val dslFiles = typeSetups.dslFiles
        val testFiles = typeSetups.map(new EventWithOnePropertyWithinOneValueTestProject(_)).testFiles
      }
    }) toSeq
}
