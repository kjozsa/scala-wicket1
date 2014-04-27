/**
 *
 */
package com.fsdev.scw

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label

/**
 * @author kjozsa
 */
class MainPage extends WebPage {
  add(new Label("hello", "hello world!"))
}