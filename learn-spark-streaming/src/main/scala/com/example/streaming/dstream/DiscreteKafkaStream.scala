package com.example.streaming.dstream

import java.io

import com.example.uitl.SparkEntrypoint
import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}
import org.apache.spark.streaming.{Seconds, StreamingContext}



object DiscreteKafkaStream extends App{

  val spark = SparkEntrypoint.buildSpark("KafkaDstream")
  val ssc = new StreamingContext(spark.sparkContext, Seconds(1))

  val kafkaParam: Map[String, Object] = Map(
    "kafka.bootstrap.servers" -> "localhost:9092",
    "key.serializer" -> classOf[StringSerializer],
    "value.serializer" -> classOf[StringSerializer],
    "key.deserializer" -> classOf[StringDeserializer],
    "value.deserializer" -> classOf[StringDeserializer]
  )
  val topic = "test_topic"

  def readFromKafka()={
    val topics = Array(topic)

  }
}
