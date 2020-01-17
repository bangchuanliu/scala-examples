package dataframe

import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}
import common.AbstractSpark

object DataFrameGeneration extends AbstractSpark {

  import spark.implicits._

  val columns = List("name", "age")
  val data = {
    def createList(n: Int): List[(String, Int)] = if (n == 0) Nil else ("name-" + n, n) :: createList(n - 1)
    createList(3)
  }
  val rdd = spark.sparkContext.parallelize(data)


  // create DataFrame from RDD
  val dfFromRDD1 = rdd.toDF()
  val dfFromRDD2 = rdd.toDF("name", "age")
  val dfFromRDD3 = rdd.toDF(columns: _*)
  val dfFromRDD4 = spark.createDataFrame(rdd).toDF(columns: _*)

  val schema : StructType = StructType(Array(
    StructField("name", StringType, nullable = true),
    StructField("age", IntegerType, nullable = true)
  ))
  val rowRdd = rdd.map(r => Row(r._1, r._2))
  val dfFromRDD5 = spark.createDataFrame(rowRdd, schema)

  // create DataFrame from collections
  val dfFromCollection1 = data.toDF()
  val dfFromCollection2 = data.toDF(columns:_*)
  val dfFromCollection3 = spark.createDataFrame(data).toDF(columns: _*)
  val rowData : List[Row] = data.map(d => Row(d._1, d._2))
//  val dfFromCollection4 = spark.createDataFrame(rowData, schema)
  
  // create DataFrame from structure data
  lazy val dfFromText = spark.read.json("/src/main/resources/file.txt")
  lazy val dfFromCSV = spark.read.csv("/src/main/resources/file.csv")
  lazy val dfFromJson = spark.read.json("/src/main/resources/file.json")
  
  // create DataFrame from Hive
  // create DataFrame from RDBMS
  // create DataFrame from Hbase
  // create DataFrame from Kafka

  // create DataFrame from Avro
  def df2Avro() = {
    val avro = spark.read.format("avro").load("/src/main/resources/file.avro")
  }
  
  def main(args: Array[String]): Unit = {
    
  }


}
