package com.example.produer

import java.util.Properties
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object KafkaProducerApp extends App{

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("acks", "all")

  val producer = new KafkaProducer[String, String](props)
  val topic = "test_topic"
  var i =1
  try {
    val record = new ProducerRecord[String, String](topic, i.toString, s"Hello I am number : $i")
    val metadata = producer.send(record)
    println(s"Record: ${record.key()} ${record.value()} ${metadata.get().partition()} ${metadata.get().offset()}")
    i = i+1
    Thread.sleep(10000)
  } catch {
    case e: Exception => e.printStackTrace()
  } finally {
    producer.close()
  }
}
