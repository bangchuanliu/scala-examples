package encoder

import encoder.EncoderUtils._
import utils.SparkUtil._

object OrderManager {

  import spark.implicits._

  def main(args: Array[String]): Unit = {
    createOrderDataset
  }

  def createOrderDataset: Unit = {
    val orders = Seq(new Order("piza", 12.35), new Order("steak", 31))
    val ds = orders.toDS()
    val ds2 = ds.map(order => (order, 1))
    ds.show(false)
    ds2.show(false)
  }
}
