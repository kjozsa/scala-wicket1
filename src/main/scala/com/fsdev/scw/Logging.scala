/**
 *
 */
package com.fsdev.scw

import org.slf4j.LoggerFactory
import org.slf4j.Logger

/**
 * @author kjozsa
 */
trait Logging {
  lazy val logger = LoggerFactory.getLogger(getClass)

  implicit def logging2Logger(anything: Logging): Logger = anything.logger
}
