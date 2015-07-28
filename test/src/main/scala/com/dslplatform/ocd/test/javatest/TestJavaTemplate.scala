package com.dslplatform.ocd
package test
package javatest

trait TestJavaTemplate {
  def packageName: String
  def testName: String

  def imports: Seq[String] = Nil
  def classDecorations: Seq[String] = Nil

  def leadingBlocks: Seq[String] = Nil
  def tests: Seq[test.TestComponent]

  def testBody = {
    val sb = new StringBuilder

    sb ++= "package " ++= packageName ++= ";\n\n"

    if (imports.nonEmpty) {
      imports foreach { imp =>
        sb ++= "import " ++= imp ++= ";\n"
      }

      sb += '\n'
    }

    classDecorations foreach { cd =>
      sb += '@' ++= cd += '\n'
    }
    sb ++= "public class " ++= testName ++=" {\n"

    leadingBlocks foreach { test =>
      sb ++= test
    }

    /* Quick and filthy regex replace to inject some logging, for easier report creation.
     * The reason we're putting html here, is because otherwise the heap space in the XSLT transformer
     * goes up too quickly, and the transform breaks. */
    tests foreach { test =>
      sb ++= test.testComponentBody // .trim()
          .replaceAll(
              "public[ ]+void[ ]+test([^\\(]+)\\(\\)(.*)\\{"
              ,s"""public void test$$1()$$2{
        org.slf4j.LoggerFactory.getLogger("ocd-anchor-logger").trace(
                "<a id='$packageName.$testName.test$$1'>" +
                "<h4>$packageName.$testName.test$$1</h4></a>");
        org.slf4j.MDC.put("ocdTestMethodName","test$$1:");
              """)
          ;
    }

    sb ++= "}\n" toString
  }
}
