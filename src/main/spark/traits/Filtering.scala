package traits

import org.apache.spark.sql.Dataset
import traits.Notification.Notification

class Filtering extends FilteringTrait[Notification] with BuyerIntentScoreFiltering {
  override def filter(ds: Dataset[Notification]): Dataset[Notification] = ds
}




class BuyerFiltering extends Filtering[Notification] {

  override def filter(ds: Dataset[Notification]): Dataset[Notification] = ds
  
}
