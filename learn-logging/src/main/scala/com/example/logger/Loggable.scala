package com.example.logger

import com.example.logger.impl.LoggingService

trait Loggable {
  val logger: Logger = new LoggingService(org.slf4j.LoggerFactory.getLogger(getClass))
}
