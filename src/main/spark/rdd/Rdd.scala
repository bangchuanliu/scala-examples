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
}
