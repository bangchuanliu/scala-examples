package traits

import org.apache.spark.sql.Dataset
import traits.Notification.Notification
import traits.Notification._
import utils.SparkUtil._

trait BuyerIntentScoreFiltering extends FilteringTrait[Notification] {

  import spark.implicits._

  abstract override def filter(ds: Dataset[Notification]): Dataset[Notification] = {
    val scoreDs = score

    ds.join(scoreDs)
      .where(ds("recipientMemberUrn") === scoreDs("recipientMemberUrn"))
      .filter(scoreDs("score") > 5)
      .select(ds("recipientMemberUrn"), ds("recipientContractUrn"), ds("entityUrn"), ds("notificationTime"))
      .as[Notification]
  }
}
