/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.component.IRequestablePage
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.link.BookmarkablePageLink
import org.slf4j.LoggerFactory

/**
 * @author kjozsa
 */
class HomePage extends WebPage {

  val logger = LoggerFactory.getLogger(this.getClass())
  logger.info("## hello me")

  add(new BookmarkablePageLink[HomePage]("homeLink", classOf[HomePage]))

}