package com.dslplatform.ocd
package config

import hr.element.etb.XKCD
import hr.element.etb.Workspace

trait ITestSettings {
  def xkcd: XKCD
  def workspace: Workspace
  def templates: Path

  def revenj: Revenj
  def database: Database

  def turtles: Boolean
  def projectPattern: Regex
  def typePattern: Regex
}
