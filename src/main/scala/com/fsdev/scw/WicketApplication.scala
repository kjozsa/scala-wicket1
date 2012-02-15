/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.application.IComponentInstantiationListener
import org.apache.wicket.Component
import org.wicketstuff.jsr303.PropertyValidation
import org.apache.wicket.application.IComponentInitializationListener
import org.wicketstuff.jsr303.PropertyValidator

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
  }

  //  getComponentInitializationListeners().add(new IComponentInitializationListener() {
  //    def onInitialize(component: Component) {
  //
  //      if (component.isInstanceOf[Form[_]]) {
  //        println("## form validation added")
  //        component.add(new PropertyValidation());
  //      }
  //    }
  //  })
}