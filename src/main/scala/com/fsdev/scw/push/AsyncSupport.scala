/**
 *
 */
package com.fsdev.scw.push

import org.apache.wicket.Component
import com.fsdev.scw.WicketApplication
import java.util.concurrent.Future
import scala.actors.Actor._
import java.util.concurrent.TimeUnit
import org.apache.wicket.atmosphere.EventBus
import scala.actors.Futures._

/**
 * @author kjozsa
 */
trait AsyncSupport {
  self: Component =>

  /** execute block asynchronously and post the result to the application EventBus */
  def async(block: () => Any) {
    val application = getApplication.asInstanceOf[WicketApplication]

    future {
      application.eventBus.post(new ResultEvent(block()))
    }
  }
}