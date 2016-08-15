package com.dslplatform.ocd

import com.dslplatform.ocd.dsls.OcdDslBoxType
import config.{Database, ITestSettings}

package object test {
  implicit class DslFilesCollage(val setups: Traversable[TestSetup]) extends AnyVal {
    def dslFiles = setups.foldLeft(new MFiles){ _ ++= _.dslFiles }.toMap
  }

  implicit class TestFilesCollage(val projects: Traversable[config.ITestProject]) extends AnyVal {
    def testFiles = {
      val testFilesBuilder = new MMap[Language, MFiles]

      for { p <- projects; (language, testFiles) <- p.testFiles } {
        testFilesBuilder.getOrElse(language, {
          val mFiles = new MFiles
          testFilesBuilder(language) = mFiles
          mFiles
        }) ++= testFiles
      }

      testFilesBuilder.map(e => e.copy(_2 = e._2.toMap)).toMap
    }
  }

  import types._
  /** This overrides the typePattern in testSettings, for development only - should always be commented out */
  val overrideTypes = Seq(
//    `type.Binary`
//    `type.Boolean`
//    `type.Integer`
//    `type.Double`
//    `type.Point`
//    `type.Location`
  )

  object OcdTypeSingletonExtender {
    private val postgresSupportedTypes = Seq(
      `type.Binary`
//    , `type.Bits`
    , `type.Boolean`
//    , `type.Color`
    , `type.Date`
    , `type.Decimal`
    , `type.Decimal(9)`
    , `type.Double`
//    , `type.Email`
    , `type.Float`
    , `type.Guid`
    , `type.Image`
    , `type.Integer`
    , `type.Ip`
//    , `type.Json`
    , `type.Location`
    , `type.Long`
    , `type.Map`
    , `type.Money`
//    , `type.Native`
//    , `type.Phone`
    , `type.Point`
    , `type.Rectangle`
//    , `type.S3`
//    , `type.Secret`
//    , `type.Stream`
    , `type.String`
    , `type.String(9)`
    , `type.Text`
//    , `type.Time`
    , `type.Timestamp`
    , `type.Url`
    , `type.Xml`
    )

    private val oracleSupportedTypes = Seq(
      `type.Binary`
//    , `type.Bits`
    , `type.Boolean`
//    , `type.Color`
    , `type.Date`
    , `type.Decimal`
    , `type.Decimal(9)`
    , `type.Double`
//    , `type.Email`
    , `type.Float`
    , `type.Guid`
//    , `type.Image`
    , `type.Integer`
    , `type.Ip`
//    , `type.Json`
//    , `type.Location`
    , `type.Long`
//    , `type.Map`
    , `type.Money`
//    , `type.Native`
//    , `type.Phone`
//    , `type.Point`
//    , `type.Rectangle`
//    , `type.S3`
//    , `type.Secret`
//    , `type.Stream`
    , `type.String`
    , `type.String(9)`
    , `type.Text`
//    , `type.Time`
    , `type.Timestamp`
//    , `type.Url`
//    , `type.Xml`
    )
  }

  implicit class OcdTypeSingletonExtender(val ocdType: types.OcdType.type) extends AnyVal {
    import OcdTypeSingletonExtender._

    def useCaseValues(testSettings: ITestSettings): Seq[types.OcdType] = overrideTypes match {
      case overrides if overrides.nonEmpty =>
        overrides

      case _ => (testSettings.database match {
        case Database.Oracle32
           | Database.Oracle64 => oracleSupportedTypes
        case Database.PostgreSQL => postgresSupportedTypes
      }) filter { tpe =>
        testSettings.typePattern.pattern.matcher(tpe.typeName).matches()
      }
    }
  }

  implicit class ClassyBoxTyper(val box: boxes.OcdBox) extends AnyVal {
    def around(content: String) = {
      val tmp = `type.Secret`
      val dslTmp = OcdDslBoxType.resolve(tmp, box)
      val contentInBox = dslTmp.dslName.replace(tmp.typeName, content)

      contentInBox + (
        if (contentInBox endsWith "?>?") "" else
        if (contentInBox endsWith ">?") " " else
        if (contentInBox endsWith "?>") " " else
        if (contentInBox endsWith ">") "  " else
        if (contentInBox endsWith "?") "" else " ")
    }
  }

  implicit class ClassyDSLTyper(val ocdDsl: dsls.OcdDslBoxType.type) extends AnyVal {
    def toDsl(concept: String, box: boxes.OcdBox) =
      ocdDsl.resolve(types.`type.Guid`, box).dslName.replace("Guid", concept)
  }
}
