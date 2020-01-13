package sql

import org.apache.spark.sql.SparkSession

trait AbstractSpark {
  
  lazy val spark = SparkSession
    .builder()
    .master("local")
    .appName("spark")
    .getOrCreate()
}
