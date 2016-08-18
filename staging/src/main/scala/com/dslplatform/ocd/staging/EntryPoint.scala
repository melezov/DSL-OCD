package com.dslplatform.ocd
package staging

object EntryPoint
    extends App {

  logger.info("#" * 50)
  Source()

  logger.info("#" * 50)
  Analyse()

  logger.info("#" * 50)
  Compile()

  logger.info("#" * 50)
  Download()

  logger.info("#" * 50)
  Gather()
}
