package com.example

import com.example.uitl.SparkEntrypoint
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object DataframePlayground extends App{
  val spark = SparkEntrypoint.buildSpark("dataframe playground")

  import spark.implicits._
  val columns = Seq("Course", "Count")
  val data = Seq(("Java", 1000), ("Scala", 2000), ("Python", 2500))
  val rdd = spark.sparkContext.parallelize(data)
  val rddToDF = rdd.toDF("Course", "Count")
  rddToDF.show(false)

  val rddToDFwithSpark = spark.createDataFrame(rdd).toDF(columns:_*)
  rddToDFwithSpark.show(false)

  //using toDF on List and Seq collection column names will be _1, _2 ... (when no schema)
  val collectionToDF = data.toDF
  collectionToDF.show(false)

  val schema = StructType(Array(StructField("Language", StringType, true), StructField("Users", StringType, true)))
  val rowRDD = rdd.map(f => Row(f._1, f._2))
  val rowRDDToDF = spark.createDataFrame(rowRDD, schema)
  rowRDDToDF.show(false)

}
