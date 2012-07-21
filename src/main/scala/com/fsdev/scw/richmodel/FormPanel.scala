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
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink
import org.apache.wicket.ajax.AjaxRequestTarget

/**
 * @author kjozsa
 */
class TestModel extends Serializable {
  var label: String = null

  override def toString = label
}

class FormPanel(id: String) extends Panel(id) with Logging {
  val testModel = new TestModel

  val form = new Form("form")
  add(form)

  val submit = new AjaxSubmitLink("submit") {
    override def onSubmit(target: AjaxRequestTarget, form: Form[_]) {
      logger.info("submitted model: {}", testModel)
    }
  }
  form.add(submit)

  form.add(new TextField("name", on(testModel)(_.label)))
  add(new FeedbackPanel("feedback"))
}
