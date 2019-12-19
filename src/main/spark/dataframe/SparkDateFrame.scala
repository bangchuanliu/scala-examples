package dataframe

object SparkDateFrame extends AbstractSpark {
  
  def main(args: Array[String]): Unit = {
    import spark.implicits._
    
    spark.range(2).toDF().show
    
    println(spark.range(5).toDF.schema)
    
    val d1 = Seq(1,2,3,4,5).toDF()
    val d2 = Seq(1,3,5, 7).toDF()
    
    // except
    d1.except(d2).show()
    
    // union
    d1.union(d2).show()

    // union and dedupe
    d1.union(d2).distinct().show()
    
    // left anti
    d1.join(d2, Seq("value"), "left_anti").show()
  }
  
}
