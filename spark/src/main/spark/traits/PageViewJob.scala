package traits

import traits.Notification._

object PageViewJob {
  def main(args: Array[String]): Unit = {
    val filtering = new Filtering with BuyerIntentScoreFiltering
    filtering.filter(notification).show(false)
  }
}
