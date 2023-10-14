package com.example.streaming.structure

import com.example.uitl.SparkEntrypoint
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object StructureTextStream extends App{

  val spark = SparkEntrypoint.buildSpark("structurestream")
  spark.sparkContext.setLogLevel("ERROR")
  val filePath = "C:\\Users\\mahir\\projects\\scala_learn\\spark-learn\\src\\main\\resource"
  val schema = StructType(Array(
    StructField("name", StringType,false), StructField("salary", IntegerType,false),
    StructField("address", StringType, false)))

  val df = spark.readStream
    .schema(schema)
    .csv(filePath)

  df.writeStream
    .format("console")
    .outputMode("append")
    .start
    .awaitTermination()
}
