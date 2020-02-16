package traits

import org.apache.spark.sql.Dataset
import traits.Notification.{Notification, notification}

class Filtering extends FilteringTrait[Notification] {
  override def filter(ds: Dataset[Notification]): Dataset[Notification] = ds
}

//object Filtering extends Filtering {
//  def main(args: Array[String]): Unit = {
//    filter(notification).show(false)
//  }
//}
