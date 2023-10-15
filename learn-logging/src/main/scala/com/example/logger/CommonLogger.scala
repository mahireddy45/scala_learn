package com.example.logger

trait CommonLogger {
  val logger = new LearnLogging(org.slf4j.LoggerFactory.getLogger(getClass))
}
