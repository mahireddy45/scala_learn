import sbt.Keys.{baseDirectory, unmanagedSourceDirectories, _}

ThisBuild / scalaVersion     := "2.12.8"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

resourceDirectory in Compile := baseDirectory.value / "src/main/resources"
resourceDirectory in Test := baseDirectory.value / "src/test/resources"

unmanagedSourceDirectories in Compile += baseDirectory.value / "src/main/scala"
unmanagedSourceDirectories in Test += baseDirectory.value / "src/test/scala"

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
        "com.typesafe" % "config" % "1.4.2",
        "mysql" % "mysql-connector-java" % "8.0.28"
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
  ).dependsOn(learn_logging)
)
lazy val learn_logging = (
  project in file("learn-logging"))
  .settings(
    name := "learn_logging",
      libraryDependencies ++= Seq(
      "org.slf4j" % "slf4j-api" % "1.7.32",
      "ch.qos.logback" % "logback-classic" % "1.2.6"
    ),
    // Optionally, add any specific settings for your logging module
  )
lazy val learn_apis = (
  project in file("learn-apis"))
  .settings(
    name := "learn_apis",
    libraryDependencies ++= Seq(

    ),
//    unmanagedSourceDirectories in compile += baseDirectory.value / "src/main/scala",
//    unmanagedSourceDirectories in compile += baseDirectory.value / "src/test/scala",
//    unmanagedSourceDirectories in compile += baseDirectory.value / "src/main/bin"
    // unPackConf += baseDirectory.value / "src" / "bin" -> "bin"
  )

lazy val root = (project in file("."))
  .aggregate(
    learn_apis,
    learn_kafka,
    learn_spark,
    learn_spark_streaming,
    learn_logging
  ).settings(name := "scala")
//  .dependsOn(learn_logging)
