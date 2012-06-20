/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.protocol.http.WebApplication
import org.slf4j.LoggerFactory

/**
 * @author kjozsa
 */
class WicketApplication extends WebApplication {
  val logger = LoggerFactory.getLogger(classOf[WicketApplication])

  def getHomePage() = classOf[FormTestPage]
}