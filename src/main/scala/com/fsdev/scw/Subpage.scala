/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.component.IRequestablePage
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.Model
import org.apache.wicket.model.PropertyModel

/**
 * @author kjozsa
 */
class Subpage extends WebPage {
  println("\n######## subpage creation\n\n")

  Thread.sleep(3000)

  add(new Label("count", new PropertyModel(this, "counter")))
}

object Subpage {
  var counter = 0

  def count = {
    println("\n\n###########@@@@@@ called count " + counter)
    counter += 1
    counter
  }
}
