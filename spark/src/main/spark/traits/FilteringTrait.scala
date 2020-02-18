package traits

import org.apache.spark.sql.Dataset

trait FilteringTrait[T] {
  def filter(ds: Dataset[T]): Dataset[T]
}
