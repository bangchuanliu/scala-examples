package spark

import org.apache.spark.sql.SparkSession

class AbstractSpark {
  protected val spark = SparkSession.builder
    .master("local")
    .appName("spark-examples")
    .getOrCreate()
}
