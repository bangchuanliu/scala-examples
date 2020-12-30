import sbt.Keys._

ThisBuild / scalaVersion := "2.11.11"
ThisBuild / organization := "scala-examples"
ThisBuild / version := "0.1.0-SNAPSHOT"

val spark_sql = "org.apache.spark" %% "spark-sql" % "2.0.2"
val spark_core = "org.apache.spark" %% "spark-core" % "2.0.2"
val spark_avro = "org.apache.spark" %% "spark-avro" % "2.4.0"
val spark_ml = "org.apache.spark" %% "spark-mllib" % "2.3.4"
val junit = "junit" % "junit" % "4.12" % Test
val scalatest = "org.scalatest" %% "scalatest" % "3.0.0" % Test

val sparkLib = Seq(spark_core, spark_sql, spark_avro, spark_ml)
val scalatestLib = Seq(scalatest, junit)

lazy val scalaLang = project
  .in(file("scalalang"))
  .settings(
    name := "scalaLang",
    libraryDependencies ++= scalatestLib
  )

lazy val spark = project
  .in(file("spark"))
  .settings(
    name := "spark",
    libraryDependencies ++= sparkLib
  )

lazy val fpInScala = project
  .in(file("fpinscala"))
  .settings(
    name := "fpInScala",
    libraryDependencies ++= scalatestLib
  )





