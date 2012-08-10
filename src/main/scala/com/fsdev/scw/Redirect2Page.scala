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

/**
 * test redirection
 * @author kjozsa
 */
class Redirect2Page extends WebPage {
  throw new RedirectToUrlException("http://index.hu/")
}