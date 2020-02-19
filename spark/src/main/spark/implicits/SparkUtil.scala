package implicits

import org.apache.spark.sql.Dataset

import scala.reflect.ClassTag

object SparkUtil {

  def printDataset[T](ds: Dataset[T])(implicit tag: ClassTag[T]): Unit = {
    println(ds)
    println(tag.runtimeClass)
  }

  def printT[T](t: T)(implicit tag: ClassTag[T]): Unit = {
    println(t)
    println(tag.runtimeClass)
  }

}
