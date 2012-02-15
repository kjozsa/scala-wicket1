/**
 *
 */
/**
 * @author kjozsa
 *
 */
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.apache.wicket.util.tester.WicketTester
import com.fsdev.scw.WicketApplication
import com.fsdev.scw.CometTestPage

@RunWith(classOf[JUnitRunner])
class TestHomePage extends FunSuite {

  test("load home page") {
    val tester = new WicketTester(new WicketApplication)
    tester.startPage(new CometTestPage)

    tester.assertRenderedPage(classOf[CometTestPage])
  }
}