package models

object Entity {

  case class Notification(recipientMemberUrn: String,
                          recipientContractUrn: String,
                          entityUrn: String,
                          notificationTime: Long)
  
}
