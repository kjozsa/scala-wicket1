/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.protocol.http.WebApplication

/**
 * @author kjozsa
 */
class WicketApplication extends WebApplication with Logging {
  override def getHomePage() = classOf[MainPage]
}
