package com.dslplatform.ocd
package `test.scalas`

trait TestScalaTemplate {
  def basePackageName: String
  def testPackageName: String
  def testName: String

  def imports: Seq[String] = Nil
  def staticFields: Seq[String] = Nil
  def beforeClass: Seq[String] = Nil
  def afterClass: Seq[String] = Nil
  def beforeTest: Seq[String] = Nil
  def afterTest: Seq[String] = Nil
  def helperMethods: Seq[String] = Nil

  def tests: Seq[test.TestComponent]

  def testBody = {
    val sb = new StringBuilder

    sb ++= s"""package ${basePackageName}
package ${testPackageName}

import org.scalatest._
import com.dslplatform.ocd.test._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

"""

    if (imports.nonEmpty) {
      imports foreach { imp =>
        sb ++= "import " + imp + "\n"
      }

      sb += '\n'
    }

    sb ++= s"""@RunWith(classOf[JUnitRunner])
class ${testName}
    extends OcdSpec {
"""

    tests foreach { test =>
      sb ++= test.testComponentBody
    }

    sb ++= """}
"""
    sb.toString
  }
}
