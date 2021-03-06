package sql

import utils.SparkUtil.spark

object Select {
  
  import spark.implicits._
  
  case class User(name: String, age: Int)

  def main(args: Array[String]): Unit = {
//    columnUsage
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
