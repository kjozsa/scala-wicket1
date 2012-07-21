/**
 *
 */
package com.fsdev.scw.push

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

import scala.util.Random

import com.fsdev.scw.WicketApplication

/**
 * refactored sample scheduling from WicketApplication
 * @author kjozsa
 */
trait SampleScheduling {
  self: WicketApplication =>

  val scheduler = Executors.newScheduledThreadPool(1)

  schedule(2) {
    new OneEvent(Random.nextInt(1000))
  }

  schedule(3) {
    new OtherEvent("foo " + Random.nextInt(10) + " bar")
  }

  def schedule(interval: Int)(data: => Event) {
    scheduler.scheduleAtFixedRate(new Runnable {
      override def run() {
        eventBus.post(data)
      }
    }, 1, interval, TimeUnit.SECONDS)
  }

  override def onDestroy {
    scheduler.shutdown
  }
}