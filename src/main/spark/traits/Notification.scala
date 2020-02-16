package traits

import utils.SparkUtil._

object Notification {

  import spark.implicits._

  case class Notification(
                           recipientMemberUrn: String,
                           recipientContractUrn: String,
                           entityUrn: String,
                           notificationTime: Long
                         )


  case class BuyerIntentScore(
                               recipientMemberUrn: String,
                               score: Double
                             )


  val notification = List(
    Notification("m1", "c1", "e1", System.currentTimeMillis()),
    Notification("m2", "c2", "e2", System.currentTimeMillis()),
    Notification("m3", "c3", "e3", System.currentTimeMillis())
  ).toDS


  val score = List(
    BuyerIntentScore("m1", 4.6),
    BuyerIntentScore("m2", 5.6),
    BuyerIntentScore("m3", 7.6)
  ).toDS
}
