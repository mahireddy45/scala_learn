import Dependencies._
import sbt.Keys.{baseDirectory}

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

resourceDirectory in Compile := baseDirectory.value / "src/main/resources"
resourceDirectory in Test := baseDirectory.value / "src/test/resources"

lazy val learn_kafka = (
  Project("learn-kafka", file("learn-kafka"))
    .settings(
      name := "learn_kafka",
      libraryDependencies ++= Seq(
        "org.apache.kafka" %% "kafka" % "2.4.1",
        "org.apache.kafka" % "kafka-clients" % "2.4.1"
      )
    )
  )
lazy val learn_spark = (
  Project("learn-spark", file("learn-spark"))
    .settings(
      name := "learn_spark",
      libraryDependencies ++= Seq(
        "org.apache.spark" %% "spark-core" % "2.4.8",
        "org.apache.spark" %% "spark-sql" % "2.4.8",
        "org.apache.spark" %% "spark-hive" % "2.4.8",
        "com.typesafe" % "config" % "1.4.2"
      )
    )
  )

lazy val learn_spark_streaming = (
  Project("learn-spark_streaming", file("learn-spark-streaming"))
  .settings(
    name := "learn_spark_streaming",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % "2.4.8",
      "org.apache.spark" %% "spark-sql" % "2.4.8",
      "org.apache.spark" %% "spark-hive" % "2.4.8",
      "org.apache.spark" %% "spark-streaming" % "2.4.8",
      "org.apache.spark" %% "spark-sql-kafka-0-10" % "2.4.8",
      "com.typesafe" % "config" % "1.4.2"
    )
  )
)

lazy val root = (project in file("."))
  .aggregate(
    learn_kafka,
    learn_spark,
    learn_spark_streaming
  ).settings(name := "scala")