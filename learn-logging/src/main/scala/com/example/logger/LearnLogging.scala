package com.example.logger

trait Logger {
  def info(message: String)
  def error(message: String)
  def warn(message: String)
}

class LearnLogging(logger: org.slf4j.Logger) extends Logger {
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
