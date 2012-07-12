/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.slf4j.LoggerFactory
import com.fsdev.scw.ModelFactory.on
import org.apache.wicket.markup.html.form.Form
import org.slf4j.Logger
import org.apache.wicket.atmosphere.Subscribe
import org.apache.wicket.ajax.AjaxRequestTarget

/**
 * @author kjozsa
 */
class TestModel extends Serializable {
  var label: String = null

  override def toString = label
}

class FormTestPage extends WebPage with Logging {
  val testModel = new TestModel

  val form = new Form("form") {
    override def onSubmit() {
      logger.info("submitted model: {}", testModel)
    }
  }
  add(form)

  form.add(new TextField("name", on(testModel)(_.label)))

  add(new FeedbackPanel("feedback"))

}
