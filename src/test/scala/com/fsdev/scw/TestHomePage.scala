/**
 * @author kjozsa
 */
package com.fsdev.scw
import org.apache.wicket.util.tester.WicketTester
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TestHomePage extends FunSuite {

  test("load home page") {
    val tester = new WicketTester(new WicketApplication)
    tester.startPage(new FormTestPage)
    //    tester.assertRenderedPage(classOf[FormTestPage])
  }
}