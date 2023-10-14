package com.example.consumer

import java.util.Properties
import org.apache.kafka.clients.consumer.KafkaConsumer
import scala.collection.JavaConverters._

object KafkaConumerApp extends App{
  val props = new Properties()
  props.put("group.id", "test")
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")

  val consumer = new KafkaConsumer(props)
  val topics = List("test_topic")
  try {
    consumer.subscribe(topics.asJava)
    val records = consumer.poll(10)
    for( record <- records.asScala){
      println(s"Record subscribed => Topic: ${record.topic} Key: ${record.key()} value: ${record.value()}")
    }
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    consumer.close()
  }
}
