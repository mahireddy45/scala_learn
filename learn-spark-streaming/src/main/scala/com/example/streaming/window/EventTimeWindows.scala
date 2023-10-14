package com.example.streaming.window

import com.example.uitl.SparkEntrypoint

object EventTimeWindows extends App{
  val spark = SparkEntrypoint.buildSpark("eventtime")

}
