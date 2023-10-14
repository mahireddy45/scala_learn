package com.example.streaming.structure

import org.apache.spark.sql.SparkSession

object KafkaStreaming extends App {

  val spark = SparkSession.builder().master("local[3]").appName("Kafka stream").getOrCreate()

  val kafkastream = spark.readStream
    .format("kafka")
    .option("kafka.bootstrap.servers", "localhost:2181")
    .option("subscribe", "topic1")
    .load()

  kafkastream.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
    .writeStream.format("console")
    .outputMode("append")
    .start()
    .awaitTermination()

}
