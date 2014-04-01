package com.dslplatform.ocd
package javas
package turtle

import config._
import test._
import javatest._

class OcdJavaDefaultsEqualityTurtle
    extends ITestProject {

  def projectPath = "turtles/defaults-equality"
  def projectName = "OCD Java Defaults Equality Turtle"

  def dslFiles = Map.empty
  def testFiles = Map(
    JAVA -> (for (oj <- OcdJava.values) yield {
      JavaInfo(makeTemplate(oj).testBody).toEntry
    }).toMap
  )

  private def makeTemplate(oj: OcdJava) = {
    val name = oj.boxName + (if (oj.areElementsNullable.isEmpty) oj.typeSingleName else oj.typePluralName)
    val _testName = s"${name}FieldTurtle"

    new TestJavaTemplate {
      def packageName = "com.dslplatform.ocd.javas.turtles." + oj.typeSingleName
      def testName = _testName

      override def imports = Seq(
        "com.dslplatform.client.JsonSerializationDinamo"
      , "com.dslplatform.client.Bootstrap"
      , "com.dslplatform.patterns.ServiceLocator"
      , "com.fasterxml.jackson.databind.JavaType"
      , "java.io.IOException"
      )

      override def leadingBlocks = Seq("""
    private static JsonSerializationDinamo jsonSerialization;

    @org.junit.BeforeClass
    public static void initializeJsonSerialization() throws IOException {
/*
          final ServiceLocator locator = Bootstrap.init(new java.io.ByteArrayInputStream(
                "username=x\nproject-id=x\napi-url=x\npackage-name=x".getBytes("UTF-8")));
        jsonSerialization = locator.resolve(JsonSerialization.class);
*/
        jsonSerialization = new JsonSerializationDinamo(null);
    }
""")

      val clazz = oj.javaClass

      def tests = Seq(new TestComponent{
        def testComponentBody = s"""
    /* Performs equality checks on all border values */
    @org.junit.Test
    public void testBorderValueEqualities() throws IOException {${
      oj.borderValues.zipWithIndex.map { case (bv, index) =>
        testBorderValue(oj, "borderValue" + (index + 1), bv)
       }.mkString}
    }
"""
      })
    }
  }

  import types._
  import boxes._
  import javas._

  private def buildType(javaType: JavaType): String = javaType match {
    case JavaClass(baseClass) =>
      s"""${baseClass}.class"""

    case SimpleType(baseClass) =>
      s"""JsonSerializationDinamo.buildType(${baseClass}.class)"""

    case CollectionType(baseClass, elementType) =>
      s"""JsonSerializationDinamo.buildCollectionType(${baseClass}.class, ${buildType(elementType)})"""

    case GenericType(baseClass, elementTypes @ _*) =>
      s"""JsonSerializationDinamo.buildGenericType(${baseClass}.class, ${elementTypes.map(buildType).mkString(", ")})"""
  }

  private def testBorderValue(oj: OcdJava, name: String, value: JavaValue) = s"""
        final ${oj.javaClass} ${name} = ${value};
        final String ${name}JsonSerialized = jsonSerialization.serialize($name);
        final JavaType ${name}JavaType = ${buildType(oj.javaType)};
        final ${oj.javaClass} ${name}JsonDeserialized = jsonSerialization.deserialize(${name}JavaType, ${name}JsonSerialized);
        com.dslplatform.ocd.javaasserts.${oj.typeSingleName}Asserts.assert${oj.boxName}Equals(${name}, ${name}JsonDeserialized);
"""
}