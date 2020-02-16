package traits

import org.apache.spark.sql.Dataset

trait AbstractFiltering[T] {
  def filter(ds: Dataset[T]): Dataset[T]
}
