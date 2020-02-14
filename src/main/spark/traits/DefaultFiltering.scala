package traits

import org.apache.spark.sql.Dataset

class DefaultFiltering[T] extends Filtering[T] {
  
  override def filter(ds: Dataset[T]): Dataset[T] = ds
}
