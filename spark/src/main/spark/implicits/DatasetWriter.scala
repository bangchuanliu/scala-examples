package implicits

import org.apache.spark.sql.Dataset

import scala.reflect.ClassTag

class DatasetWriter[T](val ds: Dataset[T]) {

  def write(implicit tag: ClassTag[T]): Unit = {
    SparkUtil.printDataset(ds)
  }
}
