/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.request.component.IRequestablePage
import com.fsdev.scw.push.PushPanel
import com.fsdev.scw.richmodel.FormPanel

/**
 * @author kjozsa
 */
class MainPage extends WebPage {
  add(new FormPanel("formPanel"))
  add(new PushPanel("pushPanel"))
}