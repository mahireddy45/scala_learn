package com.example.streaming.dstream

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.DStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import com.example.conf.ConfManager

object DiscreteTextStream  extends App{

//  private val input = ConfManager.getConfig("com.example.stream.in.dstream")
//  val filePath = input.getString("file_path")
  val filePath = "C:\\Users\\mahir\\projects\\scala_learn\\spark-learn\\src\\main\\resource"

  val sparkConf = new SparkConf().setAppName("dstream").setMaster("local[3]")
  val ssc = new StreamingContext(sparkConf, Seconds(10))
//  ssc.sparkContext.setLogLevel("ERROR")
  val textStream = ssc.textFileStream(filePath)
  val empployee: DStream[Employee] = textStream.map{ line =>
    val column = line.split(",")
    Employee(column(0), column(1).toInt, column(2))
  }
  empployee.print()
  ssc.start()
  ssc.awaitTermination()
}
case class Employee(name:String, salary: Int, address:String)
