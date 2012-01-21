/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.Page
import org.slf4j.LoggerFactory

/**
 * @author kjozsa
 */
class WicketApplication extends WebApplication {

  def getHomePage() = classOf[HomePage]

}