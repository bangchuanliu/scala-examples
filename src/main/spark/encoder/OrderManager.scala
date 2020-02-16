package encoder

import encoder.EncoderUtils._
import org.apache.spark.sql.Row
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}
import utils.SparkUtil._

object OrderManager {

  import spark.implicits._

  def main(args: Array[String]): Unit = {
    createOrderDatasetWithEncoder
  }

  def createOrderDataset: Unit = {
    val orders = Seq(new Order("piza", 12.35), new Order("steak", 31))
    val ds = orders.toDS()
    val ds2 = ds.map(order => (order.food, order.price))
    ds.show(false)
    ds2.show(false)
  }

  def createOrderDatasetWithEncoder: Unit = {
    val orders = Seq(new Order("piza", 12.35), new Order("steak", 31))
    val schema = StructType(
      List(
        StructField("food", StringType, nullable = true),
        StructField("price", DoubleType, nullable = true)
      )
    )
    
    val rowRdd = spark.sparkContext.parallelize(orders).map(order => Row(order.food, order.price))
    val df = spark.createDataFrame(rowRdd, schema)
    val ds2 = df.map(order => new Menu(order.getString(0))) // need encoder for Menu class
    df.show(false)
    ds2.show(false)
  }
}
