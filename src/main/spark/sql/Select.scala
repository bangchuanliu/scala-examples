package sql

import org.apache.spark.sql._

object Select extends AbstractSpark {
  
  case class User(name: String, age: Int)
  
  import spark.implicits._

  def main(args: Array[String]): Unit = {
//    columnUsage
    join()
  }
  

  def join() = {
    val df1 = List(User("kevin", 21), User("peter", 32)).toDF
    val df2 = List(User("kevin", 21), User("jason", 33)).toDF
    
    df1.join(df2).show(false)
    df1.except(df2).show(false)
    df1.join(df2, Seq("name"), "inner")
    
  }
  
  
  def columnUsage(): Unit = {
    val df = List(User("kevin", 21), User("peter", 32)).toDF
    df.select(df.col("name")).show(false)
    df.select("name").show(false)
    df.select($"name").show(false)
    df.selectExpr("name as student_name", "age").show
    df.selectExpr(
      "*",
      "(dest_country_name = origin_country_name) as withincountry")
//    df.withColumn("today", current_date())
//      .withColumn("now", current_timestamp())
  }

}
