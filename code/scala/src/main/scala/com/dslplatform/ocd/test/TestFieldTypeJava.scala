package com.dslplatform.ocd
package test
package java

trait TestJavaFieldType
    extends TestJavaTemplate
    with types.TestFieldType {

  def javaClass: String
  def fieldName: String
  def fieldClass: String

  def testJavaFieldType = s"""
    @Test
    public void TestFieldType() throw NoSuchFieldException {
        assertTrue(new FieldTester(${javaClass}.class, "${fieldName}").typeEquals(${fieldClass}.class));
    }
"""
}
