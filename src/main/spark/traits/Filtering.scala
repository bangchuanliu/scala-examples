package traits

import org.apache.spark.sql.Dataset

abstract class Filtering[T] {
  
  def filter(ds : Dataset[T]) : Dataset[T]
}
