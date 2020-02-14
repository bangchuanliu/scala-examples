package rdd

import org.apache.spark.sql.SparkSession
import utils.SparkUtil._
object Rdd {

  import spark.implicits._

  def main(args: Array[String]): Unit = {
    count
  }

  def count() = {
    val words = List("a b c", "b c d", "c d e")
    val rdd = spark.sparkContext.parallelize(words)
    val countedRdd = rdd.flatMap(line => line.split(" ")).map(w => (w , 1)).reduceByKey(_ + _)
    val count = rdd.filter(line => line.contains("A")).count()
    countedRdd.toDF().show(false)
  }


  def nestedStructType: DataFrame = {
    val struct = StructType(
      List(
        StructField("insighttagurn", StringType, nullable = true),
        StructField("insighttagurn", StringType, nullable = true)
      ))

    val row = StructType(
      List(
        StructField("key", struct, nullable = true)
      )
    )

    val rowRdd = spark.sparkContext.parallelize(List(List("urn:tsp:insightTag:6917", "urn:li:contract:18615004"))).map(r => Row(Row(r.get(0), r.get(1))))
    spark.createDataFrame(rowRdd, row)
  }
}
