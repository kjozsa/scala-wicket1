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

/**
 * @author kjozsa
 */
class WicketApplication extends WebApplication {
  lazy val logger = LoggerFactory.getLogger(classOf[WicketApplication])
  lazy val eventBus = new EventBus(this)

  override def getHomePage() = classOf[PushPage]

  Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable {
    override def run() {
      logger.info("pushing to event bus")
      eventBus.post(new Date)
    }
  }, 2, 2, TimeUnit.SECONDS)
}