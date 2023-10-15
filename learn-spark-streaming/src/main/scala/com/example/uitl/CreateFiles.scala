package com.example.uitl

import java.io.{File, FileWriter}
import com.example.logger.CommonLogger
import com.example.conf.ConfManager
import com.typesafe.config.Config
import scala.util.Random

object CreateFiles extends App with CommonLogger{
  logger.info("Creating files for testing....")
//  private val input: Config = ConfManager.getConfig("com.example.stream.in.dstream")
//  val filePath = input.getString("file_path")
  val filePath = "C:\\Users\\mahir\\projects\\scala_learn\\learn-spark-streaming\\src\\main\\resource"

  new Thread(() => {
    while(true){
      val newFile = new File(s"$filePath/employee${System.currentTimeMillis()}.csv")
      val writer = new FileWriter(newFile)
      writer.write(s"""Veena,${Random.nextInt()},Hyd
           |Mahi,${Random.nextInt()},Hyd
           |Anil,${Random.nextInt()},KNR
           |""".stripMargin)
      writer.close()
      Thread.sleep(30000)
    }
  }).start()
}

//standard way of mutables. Like Setter and getter
//val filePath1 = new MutableWrapper[String]
class MutableWrapper[T]{
  private var defaultValueTypeAny: T = _
  def value: Option[T] = Option(defaultValueTypeAny)
  def value_=(newValue: T) :Unit ={defaultValueTypeAny = newValue}
}