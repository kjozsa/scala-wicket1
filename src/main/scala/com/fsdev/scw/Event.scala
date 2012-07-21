/**
 *
 */
package com.fsdev.scw

/**
 * @author kjozsa
 */
sealed abstract class Event

case class OneEvent(data: Int) extends Event
case class OtherEvent(data: String) extends Event
