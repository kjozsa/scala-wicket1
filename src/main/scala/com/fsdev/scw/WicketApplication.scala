/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.atmosphere.EventBus
import org.apache.wicket.protocol.http.WebApplication
import org.slf4j.LoggerFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.Date
import scala.util.Random

/**
 * @author kjozsa
 */
class WicketApplication extends WebApplication {
  lazy val logger = LoggerFactory.getLogger(classOf[WicketApplication])
  lazy val eventBus = new EventBus(this)
  val scheduler = Executors.newScheduledThreadPool(1)

  override def getHomePage() = classOf[PushPage]

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