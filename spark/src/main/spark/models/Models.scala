package models

object Models {

  case class Notification(recipientMemberUrn: String,
                          recipientContractUrn: String,
                          entityUrn: String,
                          notificationTime: Long)


  case class Person(name: String, age: Int)
}
