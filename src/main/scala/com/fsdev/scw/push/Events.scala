/**
 *
 */
package com.fsdev.scw.push

/**
 * @author kjozsa
 */
sealed abstract class Event

case class OneEvent(data: Int) extends Event
case class OtherEvent(data: String) extends Event
case class ResultEvent(data: Any) extends Event
