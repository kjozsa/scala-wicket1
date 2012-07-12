/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.atmosphere.Subscribe
import org.apache.wicket.model.Model
import java.util.Date
import java.text.DateFormat

/**
 * @author kjozsa
 */
class PushPage extends WebPage with Logging {
  val pushLabel = new Label("pushLabel", new Model)
  pushLabel.setOutputMarkupId(true)
  add(pushLabel)

  @Subscribe
  def update(target: AjaxRequestTarget, event: Date) {
    logger.debug("push update event: {}", event)

    pushLabel.setDefaultModelObject(event.getTime)
    target.add(pushLabel)
  }
}