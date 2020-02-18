package utils

import org.apache.spark.sql.SparkSession

object SparkUtil {
  
  implicit lazy val spark = SparkSession
    .builder()
    .master("local")
    .appName("spark")
    .getOrCreate()
}
