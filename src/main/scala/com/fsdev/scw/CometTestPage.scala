/**
 *
 */
package com.fsdev.scw

import java.util.Date
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.model.PropertyModel
import org.apache.wicket.protocol.http.WebApplication
import org.slf4j.LoggerFactory
import org.wicketstuff.push.cometd.CometdPushService
import org.wicketstuff.push.AbstractPushEventHandler
import org.wicketstuff.push.IPushEventContext
import org.wicketstuff.push.IPushNode
import org.apache.activemq.broker.BrokerService
import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.Session

/**
 * @author kjozsa
 */
class CometTestPage extends WebPage {
  val logger = LoggerFactory.getLogger(this.getClass())

  var time = ""
  val timeLabel = new Label("timeLabel", new PropertyModel(this, "time"))
  timeLabel.setOutputMarkupId(true)
  add(timeLabel)

  val pushNode = CometdPushService.get().installNode(this, new AbstractPushEventHandler[Any] {
    override def onEvent(target: AjaxRequestTarget, message: Any, node: IPushNode[Any], context: IPushEventContext[Any]) {
      logger.info("######@@@@@ push onEvent \n\n")
      time = new Date().toString
      target.add(timeLabel)
    }
  })

  new Thread {
    val app = getApplication().asInstanceOf[WebApplication]

    override def run() {
      while (true) {
        logger.info("### timer tick")
        CometdPushService.get(app).publish(pushNode, null)
        Thread.sleep(1000)
      }
    }
  }.start()

  //  add(new BookmarkablePageLink[HomePage]("homeLink", classOf[HomePage]))
  //
  add(new AjaxLink("startJms") {
    override def onClick(target: AjaxRequestTarget) {
      logger.info("###### ajax link clicked\n\n")

      val connectString = "tcp://localhost:61000"
      val broker = new BrokerService()
      broker.setBrokerName("test1")
      broker.setUseShutdownHook(true)
      broker.addConnector(connectString)
      broker.start()
      broker.waitUntilStarted()

      logger.info("broker has set up")

      val connectionFactory = new ActiveMQConnectionFactory(connectString)
      val connection = connectionFactory.createConnection
      val session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE); // transacted, ackmode
      session.commit()
      connection.start()
    }
  })
}