package com.dslplatform.ocd.config

import java.util.concurrent.atomic.AtomicLong

import com.github.nscala_time.time.Imports._

object XKCD {
  private val tag = new AtomicLong

  def now: XKCD = {
    val dt = DateTime.now
    val rnd = tag addAndGet 1
    XKCD(dt, rnd)
  }
}

case class XKCD(dt: DateTime, seed: Long) {
  val time = dt toString "YYYY-MM-dd-HH-mm-ss-SSS"
  val xkcd = "%016x" format seed

  override val toString = time + '-' + xkcd
}
