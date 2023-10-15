package com.example

import java.lang

import com.example.uitl.SparkEntrypoint
import org.apache.spark.sql.Dataset

object RddPlayground extends App{
  val spark = SparkEntrypoint.buildSpark("rdd playground")
  val sc = spark.sparkContext

  //create RDD using Parallelize with Array
  val rdd1 = sc.parallelize(Array(1,2,3,4,5))
  rdd1.collect().foreach(println)

  //textFile() & wholeTextFile()
  val rdd2 = sc.textFile("C:\\Users\\mahir\\projects\\scala_learn\\testdata\\*.csv")
  //rdd2.collect().foreach(println)
  rdd2.foreach(f => println(f))

  val rdd3 = sc.wholeTextFiles("C:\\Users\\mahir\\projects\\scala_learn\\testdata\\*.csv")
  //rdd2.collect().foreach(println)
  rdd3.foreach(f => println(s"File : ${f._1} Data => ${f._2}"))

  //create rdd from dataset and dataframe
  val ds1: Dataset[lang.Long] = spark.range(10)
  ds1.toDF().rdd.foreach(println)
}
