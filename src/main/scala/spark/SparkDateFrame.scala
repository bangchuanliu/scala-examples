package spark

object SparkDateFrame extends AbstractSpark {
  
  def main(args: Array[String]): Unit = {
    spark.range(2).toDF().show
    
    println(spark.range(5).toDF.schema)
  }
  
}
