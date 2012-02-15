/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.html.WebPage

import com.fsdev.scw.ModelFactory.on

import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * @author kjozsa
 */
class TestModel extends Serializable {
  @NotNull
  @Size(min = 2, max = 4)
  var label: String = ""
}

class FormTestPage extends WebPage {
  val testModel = new TestModel

  val form = new Form("form")
  add(form)

  form.add(new TextField("name", on(testModel)(_.label)))
  add(new FeedbackPanel("feedback"))

}