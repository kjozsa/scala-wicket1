/**
 *
 */
package com.fsdev.scw.richmodel

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.panel.FeedbackPanel
import com.fsdev.scw.richmodel.ModelFactory.on
import com.fsdev.scw.Logging
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.panel.Panel

/**
 * @author kjozsa
 */
class TestModel extends Serializable {
  var label: String = null

  override def toString = label
}

class FormPanel(id: String) extends Panel(id) with Logging {
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
