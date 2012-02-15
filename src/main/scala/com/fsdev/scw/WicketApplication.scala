/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.application.IComponentInstantiationListener
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.Component
import org.wicketstuff.jsr303.PropertyValidation

import com.fsdev.scw.comet.CometTestPage

/**
 * @author kjozsa
 */
class WicketApplication extends WebApplication {

  def getHomePage() = classOf[FormTestPage]

  override def init() {
    super.init()

    getComponentInstantiationListeners().add(new IComponentInstantiationListener() {
      def onInstantiation(component: Component) {
        if (component.isInstanceOf[Form[_]]) {
          println("## form validation added")
          component.add(new PropertyValidation());
        }
      }
    })

    mountPage("comet", classOf[CometTestPage])
  }
}