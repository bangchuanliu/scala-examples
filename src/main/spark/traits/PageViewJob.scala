package traits
import utils.SparkUtil._

object PageViewJob {
  import spark.implicits._

  def main(args: Array[String]): Unit = {
    val ds = List(1, 2).toDS

    val filtering = new DefaultFiltering[Int]

    val ds2 = filtering.filter(ds)
    println(ds2.collect().toList)
  }

}
