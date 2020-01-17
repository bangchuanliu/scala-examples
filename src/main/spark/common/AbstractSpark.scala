package common

import org.apache.spark.sql.SparkSession

trait AbstractSpark {
  
  lazy val spark = SparkSession
    .builder()
    .master("local")
    .appName("spark")
    .getOrCreate()

  case class Notification(recipientMemberUrn: String,
                          recipientContractUrn: String,
                          entityUrn: String,
                          notificationTime: Long)
  
  
}
