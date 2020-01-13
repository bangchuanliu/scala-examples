package sql

object Sqlquery extends AbstractSpark {
  import spark.implicits._
  case class User(name: String, age: Int)
  def main(args: Array[String]): Unit = {
    sql
  }

  def sql() = {
    val data = List(User("kevin", 21), User("peter", 32))
    data.toDF().createOrReplaceTempView("user")
    spark.sql("select * from user").show(false)
  }

  def sqlfromJson(): Unit = {
    val data = spark.read.json()
  }
}
