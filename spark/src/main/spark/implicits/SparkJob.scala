package implicits

import utils.SparkUtil._

object SparkJob {

  import spark.implicits._

  def main(args: Array[String]): Unit = {
    val ds = List(1, 2).toDS
    new DatasetWriter(ds).write
//    new TWriter[String]("hello").write
  }
}
