package com.example.conf

import com.typesafe.config.{Config, ConfigFactory}

object ConfManager {

  var config: Config = ConfigFactory.load.resolve

  def getConfig: Config = config

  def getConfig(path: String): Config = config.getConfig(path)

  def setConfig(conf: String) = {
    config = ConfigFactory.parseString(conf).resolve()
  }

  def setConfig(conf: Config) ={
    config = conf.resolve()
  }

  def safeGetConfig(path: String): Option[Config] ={
    try {
      Option(getConfig(path))
    }catch {
      case _: Exception => None
    }
  }

}
