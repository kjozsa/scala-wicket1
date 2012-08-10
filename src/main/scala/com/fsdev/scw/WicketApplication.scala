/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.Component
import org.apache.wicket.RestartResponseAtInterceptPageException
import org.apache.wicket.atmosphere.EventBus
import org.apache.wicket.authorization.Action
import org.apache.wicket.authorization.IAuthorizationStrategy
import org.apache.wicket.protocol.http.WebApplication
import com.fsdev.scw.push.SampleScheduling
import org.apache.wicket.request.component.IRequestableComponent

/**
 * @author kjozsa
 */
class WicketApplication extends WebApplication with Logging with SampleScheduling {
  lazy val eventBus = new EventBus(this)

  override def getHomePage() = classOf[RedirectPage]

  override def init {
    getSecuritySettings.setAuthorizationStrategy(new IAuthorizationStrategy {
      override def isActionAuthorized(component: Component, action: Action) = {
        if (!component.isInstanceOf[Redirect2Page]) {
          logger.info("action {}, component {}", action, component)
          throw new RestartResponseAtInterceptPageException(new Redirect2Page)
        }
        true
      }
      override def isInstantiationAuthorized[T <: IRequestableComponent](clazz: Class[T]) = true
    })
  }
}
