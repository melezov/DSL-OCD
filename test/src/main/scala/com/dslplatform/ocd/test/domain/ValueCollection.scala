package com.dslplatform.ocd
package test.domain

import boxes._

case class ValueCollection(box: OcdBox, propertyName: String) {
  def PropertyName = propertyName.fciu
  def get() = s"get${PropertyName}()"
  def set(value: String) = s"set${PropertyName}($value)"
}
