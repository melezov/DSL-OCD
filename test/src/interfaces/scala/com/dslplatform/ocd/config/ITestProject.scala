package com.dslplatform.ocd
package config

/** Everything that is necessary to deploy a test project:
 *
 *  packageName that the DSL compiler should target
 *  dslFiles for the compilation
 *  testFiles which need to be distributed into appropriate projects
 */
trait ITestProject {
  def projectPath: String
  def projectName: String
  def ProjectNameCamel: String

  def dslFiles: Files
  def testFiles: Map[Language, Files]
}
