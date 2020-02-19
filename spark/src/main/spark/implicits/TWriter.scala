package implicits
import scala.reflect.ClassTag

class TWriter[T](val t: T) {

  def write(implicit tag : ClassTag[T]): Unit = {
    SparkUtil.printT(t)
  }
}
