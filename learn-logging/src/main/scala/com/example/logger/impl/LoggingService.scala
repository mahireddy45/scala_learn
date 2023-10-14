package com.example.logger.impl

import com.example.logger.Logger

class LoggingService(logger: org.slf4j.Logger) extends Logger {
  override def info(message: String): Unit = {
    logger.info(message)
  }

  override def error(message: String): Unit = {
    logger.error(message)
  }

  override def warn(message: String): Unit = {
    logger.info(message)
  }
}
