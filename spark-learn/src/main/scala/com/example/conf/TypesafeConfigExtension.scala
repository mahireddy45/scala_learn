package com.example.conf

import com.typesafe.config.Config

class TypesafeConfigExtension(conf: Config) {

  def safeGetString(key: String) : Option[String] = {
    try {
      Option(conf.getString(key).trim)
    } catch {
      case _: Exception => None
    }
  }

  def safeGetBoolean(key: String) : Boolean = {
    try {
      conf.getBoolean(key)
    } catch {
      case _: Exception => false
    }
  }

  def safeGetBooleanWithDefault(key: String, default:Boolean = true) : Boolean = {
    try {
      conf.getBoolean(key)
    } catch {
      case _: Exception => default
    }
  }

}
object TypesafeConfigExtension{
  implicit def toTypesafeConfigExtension(config: Config) : TypesafeConfigExtension =
  new TypesafeConfigExtension(config)
}
