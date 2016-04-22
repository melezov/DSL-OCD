package com.dslplatform.ocd
package test
package domain

import config._

abstract class SetupFactory(testSettings: ITestSettings) {
  val isPostgres = testSettings.database match {
    case Database.PostgreSQL => true
    case _ => false
  }

  val isOracle = testSettings.database match {
    case Database.Oracle32
       | Database.Oracle64 => true
    case _ => false
  }
}
