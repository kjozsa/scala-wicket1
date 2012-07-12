/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.atmosphere.Subscribe

/**
 * @author kjozsa
 */
class PushPage extends WebPage with Logging {
  val pushLabel = new Label("pushLabel")
  pushLabel.setOutputMarkupId(true)
  add(pushLabel)

  @Subscribe
  def update(target: AjaxRequestTarget, event: Any) {
    logger.debug("push update event: {}", event)

    pushLabel.setDefaultModelObject(event)
    target.add(pushLabel)
  }

}