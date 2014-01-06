package com.dslplatform.ocd
package test
package value

import config._
import types._
import boxes._
import dsls._
import com.dslplatform.compiler.client.api.params.Language
import hr.element.etb.XKCD

trait SetupSinglePropertyInValue {
  def propertyType: OcdDsl
  def PropertyName = propertyType.boxName + propertyType.typeName
  def propertyName = PropertyName.fcil

  def ModuleName = "SinglePropertyInValue"
  def ValueName = PropertyName + "Value" + index
  def index: Int

  def dslTemplate =
s"""module ${ModuleName} {
  value ${ValueName} {
    ${propertyType.dslName} ${propertyName};
  }
}
"""
}

private object ValueSinglePropertyTests {
  val boxes: IndexedSeq[OcdBox] = IndexedSeq(
    `box.One`
//  , `box.OneArrayOfOne`
//  , `box.OneArrayOfNullable`
//  , `box.OneListOfOne`
//  , `box.OneListOfNullable`
//  , `box.OneSetOfOne`
//  , `box.OneSetOfNullable`
//  , `box.Nullable`
//  , `box.NullableArrayOfOne`
//  , `box.NullableArrayOfNullable`
//  , `box.NullableListOfOne`
//  , `box.NullableListOfNullable`
//  , `box.NullableSetOfOne`
//  , `box.NullableSetOfNullable`
  )

  val types: IndexedSeq[OcdType] = IndexedSeq(
//    `type.Binary`
//  , `type.Bits`
//  , `type.Bool`
//  , `type.Color`
//  , `type.Date`
//  , `type.Decimal`
//  , `type.Decimal(9)`
//  , `type.Double`
//  , `type.Email`
//  , `type.Float`
//  , `type.Guid`
//  , `type.Image`
//  ,
      `type.Integer`
//  , `type.Ip`
//  , `type.Json`
//  , `type.Location`
//  , `type.Long`
//  , `type.Map`
//  , `type.Money`
//  , `type.Native`
//  , `type.Phone`
//  , `type.Point`
//  , `type.Rectangle`
//  , `type.S3`
//  , `type.Secret`
//  , `type.Stream`
//  , `type.String`
//  , `type.String(9)`
//  , `type.Text`
//  , `type.Time`
//  , `type.Timestamp`
//  , `type.Url`
//  , `type.Xml`
  )

  val setups = for {
    b <- boxes
    t <- types
    (d, i) <- OcdDsl.resolveAll(t, b).zipWithIndex
  } yield {
    new SetupSinglePropertyInValue {
      val propertyType = d
      val index = i
    }
  }
}

trait ValueSinglePropertyTests {
  import ValueSinglePropertyTests._

  def valueSinglePropertyTests = setups map { setup =>
    new ITest { test =>
      val packageName = "com.dslplatform.ocd.values"

      val dslFiles = Map(
        s"values/${setup.ModuleName}/${setup.ValueName}.dsl" ->
        setup.dslTemplate
      )

      def testFiles = Map(
        Language.JAVA -> Map(
          "keke.java" -> "object perina;"
        )
      )
    }
  }
}

//      val javaTemplate = new TestJavaTemplate {
//        val packageName = test.packageName
//
//        val testName = "Test" + setup.ValueName
//        val testDesc = testName
//
//        val imports = Seq(
//          packageName + "." + setup.ModuleName + "." + setup.ValueName
//        )
//
//        val staticFields = ""
//        val beforeClass = ""
//        val afterClass = ""
//        val beforeTest = ""
//        val afterTest = ""
//        val helperMethods = ""
//
//        val javaType = impl.JavaTypes.resolve(setup.propertyType)
//
//        val testComponents = Seq(
//          new TestJavaPropertyFieldType {
//            def javaClass = setup.ValueName
//            def fieldClass = javaType.javaClass
//            def fieldName = setup.property.name
//          }
//        , new TestJavaPropertyGetterType {
//            def javaClass = setup.ValueName
//            def fieldClass = javaType.javaClass
//            def fieldName = setup.property.name
//          }
//        , new TestJavaPropertySetterType {
//            def javaClass = setup.ValueName
//            def fieldClass = javaType.javaClass
//            def fieldName = setup.property.name
//          }
//        , new TestJavaPropertyDefaultValue {
//            def javaClass = setup.ValueName
//            def fieldClass = javaType.javaClass
//            def fieldName = setup.property.name
//            def defaultPropertyValue = javaType.defaultValue
//          }
//        ) ++ (javaType match {
//          case _: tipe.TipeScalarType =>
//            None
//          case _ =>
//            Some(
//              new TestJavaPropertySetterNullGuard {
//                def javaClass = setup.ValueName
//                def fieldClass = javaType.javaClass
//                def fieldName = setup.property.name
//                def isNullable = javaType.isInstanceOf[box.BoxNullableType]
//              }
//            )
//        }) ++ (javaType match {
//          case _: tipe.TipeUnstableType =>
//            None
//          case _ =>
//            Some(
//              new TestJavaValueEquality {
//                def javaClass = setup.ValueName
//              }
//            )
//        })
//      }
//
//      val scalaTemplate = new TestScalaTemplate {
//        val packageName = test.packageName
//
//        val testName = "Test" + setup.ValueName
//        val testDesc = testName
//
//        val imports = Seq(
//          setup.ModuleName + "." + setup.ValueName
//        )
//
//        val scalaType = impl.ScalaTypes.resolve(setup.propertyType)
//
//        val testComponents = Seq(
//          new TestScalaPropertyFieldType {
//            def scalaClass = setup.ValueName
//            def fieldClass = scalaType.scalaClass
//            def fieldName = setup.property.name
//          }
//        , new TestScalaPropertyDefaultValue {
//            def scalaClass = setup.ValueName
//            def fieldClass = scalaType.scalaClass
//            def fieldName = setup.property.name
//            def defaultPropertyValue = scalaType.defaultValue
//          }
//        )
//      }
//
//      val javaFilePath =
//        "java/" +
//        javaTemplate.packageName.replace('.', '/') + "/" +
//        javaTemplate.testName + ".java"
//
//      val scalaFilePath =
//        "scala/" +
//        scalaTemplate.packageName.replace('.', '/') + "/" +
//        scalaTemplate.testName + ".scala"
//
//      def testFiles = Map(
//        Language.JAVA -> Map(
//          javaFilePath -> javaTemplate.testBody
//        , "java/org/junit/AssertExtensions.java" -> TestJavaAssertExtensions.body
//        )
//      , Language.SCALA -> Map(
//          scalaFilePath -> scalaTemplate.testBody
//        , "scala/org/scalatest/SpecExtensions.scala" -> TestScalaSpecExtensions.body
//        )
//      )
//    }
