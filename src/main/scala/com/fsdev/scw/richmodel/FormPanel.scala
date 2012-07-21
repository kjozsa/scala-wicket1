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
import com.fsdev.scw.WicketApplication
import com.fsdev.scw.WicketApplication
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import com.fsdev.scw.push.AsyncSupport
import scala.actors.Futures._
import com.fsdev.scw.push.ResultEvent
import org.apache.wicket.atmosphere.Subscribe

/**
 * @author kjozsa
 */
class DataBean extends Serializable {
  var name: String = null
  override def toString = name
}

class FormPanel(id: String) extends Panel(id) with Logging with AsyncSupport {
  val dataBean = new DataBean

  val form = new Form("form")
  add(form)

  val submit = new AjaxSubmitLink("submit") {
    override def onSubmit(target: AjaxRequestTarget, form: Form[_]) {
      info("submitted with ajax: " + dataBean.name)
      target.add(feedback)

      async { () =>
        Thread.sleep(1500) // simulate long-running operation before sending result
        dataBean.name.toUpperCase
      }
    }
  }
  form.add(submit)

  val nameField = new TextField("name", on(dataBean)(_.name))
  nameField.setOutputMarkupId(true)
  form.add(nameField)

  val feedback = new FeedbackPanel("feedback")
  feedback.setOutputMarkupId(true)
  add(feedback)

  @Subscribe
  def asyncUpdate(target: AjaxRequestTarget, event: ResultEvent) {
    dataBean.name = event.data.toString
    target.add(nameField)
  }
}
