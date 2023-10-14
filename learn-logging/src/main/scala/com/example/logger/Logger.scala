package com.example.logger

trait Logger {
  def info(message: String)
  def error(message: String)
  def warn(message: String)
}
