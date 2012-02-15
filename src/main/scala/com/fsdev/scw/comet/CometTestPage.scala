/**
 *
 */
package com.fsdev.scw.comet

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
import scala.reflect.BeanProperty

/**
 * @author kjozsa
 */
class CometTestPage extends WebPage {
  @BeanProperty
  var time = ""
  val logger = LoggerFactory.getLogger(this.getClass())

  val timeLabel = new Label("timeLabel", new PropertyModel(this, "time"))
  add(timeLabel.setOutputMarkupId(true))

  logger.info("## install cometd node")
  val pushNode = CometdPushService.get().installNode(this, new AbstractPushEventHandler[String] {
    override def onEvent(target: AjaxRequestTarget, event: String, node: IPushNode[String], context: IPushEventContext[String]) {
      logger.info("######@@@@@ push onEvent \n\n")
      time = new Date().toString
      target.add(timeLabel)
    }
  })
  logger.info("## installed")

  var count = 1
  new Thread {
    val app = getApplication().asInstanceOf[WebApplication]

    override def run() {
      while (count <= 5) {
        logger.info("### timer tick {}", count)
        CometdPushService.get(app).publish(pushNode, time)
        Thread.sleep(1000)
        count += 1
      }
    }
  }.start()

  //  add(new BookmarkablePageLink[HomePage]("homeLink", classOf[HomePage]))
  //
  //  add(new AjaxLink("startJms") {
  //    override def onClick(target: AjaxRequestTarget) {
  //      logger.info("###### ajax link clicked\n\n")
  //
  //      val connectString = "tcp://localhost:61000"
  //      val broker = new BrokerService()
  //      broker.setBrokerName("test1")
  //      broker.setUseShutdownHook(true)
  //      broker.addConnector(connectString)
  //      broker.start()
  //      broker.waitUntilStarted()
  //
  //      logger.info("broker has set up")
  //
  //      val connectionFactory = new ActiveMQConnectionFactory(connectString)
  //      val connection = connectionFactory.createConnection
  //      val session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE); // transacted, ackmode
  //      session.commit()
  //      connection.start()
  //    }
  //  })
}