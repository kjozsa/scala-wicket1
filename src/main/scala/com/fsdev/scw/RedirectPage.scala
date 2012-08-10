/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.component.IRequestablePage
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.request.flow.RedirectToUrlException
import org.apache.wicket.RestartResponseAtInterceptPageException
import org.apache.wicket.RestartResponseException

/**
 * test redirection
 * @author kjozsa
 */
class RedirectPage extends WebPage {
  add(new AjaxLink("redirect1") {
    override def onClick(target: AjaxRequestTarget) {
      throw new RedirectToUrlException("http://index.hu/")
    }
  })

  add(new AjaxLink("redirect2") {
    override def onClick(target: AjaxRequestTarget) {
      throw new RestartResponseAtInterceptPageException(new MainPage())
    }
  })

  add(new AjaxLink("redirect3") {
    override def onClick(target: AjaxRequestTarget) {
      throw new RestartResponseException(new Redirect2Page())
    }
  })
}