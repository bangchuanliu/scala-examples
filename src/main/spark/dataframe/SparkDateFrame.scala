package dataframe

import org.apache.spark.sql.{DataFrame, Row}
import org.apache.spark.sql.types.{DataType, IntegerType, StringType, StructField, StructType}

import scala.collection.mutable.ListBuffer

object SparkDateFrame extends AbstractSpark {

  def main(args: Array[String]): Unit = {
    createDataFrame
  }
  
  
  def highOrderFunction(): Unit = {
    import spark.implicits._

    spark.range(2).toDF().show

    println(spark.range(5).toDF.schema)

    val d1 = Seq(1, 2, 3, 4, 5).toDF()
    val d2 = Seq(1, 3, 5, 7).toDF()

    // except
    d1.except(d2).show()

    // union
    d1.union(d2).show()

    // union and dedupe
    d1.union(d2).distinct().show()

    // left anti
    d1.join(d2, Seq("value"), "left_anti").show()
  }

  case class Person(name: String, age: Int)

  def createDataFrame(): Unit = {
    import spark.implicits._
    var persons = ListBuffer[Person]()
    for (i <- 1 to 4) {
      val p = Person("a" + i, i)
      persons += p
    }
    val schema = StructType(Array(
      StructField("name", StringType, nullable = true),
      StructField("age", IntegerType, nullable = true)
    ))
    val row = Row(persons.toList)
    val sc = spark.sparkContext
    val df = spark.createDataFrame(sc.parallelize(Array(row)), schema)
    df.show()
  }

}
