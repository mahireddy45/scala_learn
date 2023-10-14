package com.example.uitl

import org.apache.spark.sql.SparkSession

object SparkEntrypoint {

  def buildSpark(appName:String): SparkSession ={
    val spark = SparkSession.builder()
      .master("local[3]")
      .appName(appName)
      .getOrCreate()
    spark
  }
}
