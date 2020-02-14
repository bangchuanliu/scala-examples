package encoder

import org.apache.spark.sql.SparkSession
import encoder.EncoderUtils._
import utils.SparkUtil._

object OrderReport {

  def main(args: Array[String]): Unit = {
    orderEncoder
  }

  def orderEncoder(implicit spark: SparkSession): Unit = {
    import spark.implicits._
    val orders = List(new Order("piza", 12.35), new Order("steak", 31))
    val ds = orders.toDS()
    ds.show(false)
  }
}
