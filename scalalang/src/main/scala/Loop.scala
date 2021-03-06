package main.scala

object Loop {
  def main(args: Array[String]): Unit = {
    for (i <- 1 to 5) {
      println(i)
    }

    for (i <- 1 to 5 by 2) {
      println(i)
    }

    for (i <- 1 until 5) {
      println(i)
    }

    for (i <- 5 to 1 by -1) {
      println(i)
    }
    
    var i = 0
    while (i < 10) {
      println(i)
      i = i + 1
    }
    
    val tableNames = List("anonymous_notification_1", "anonymous_notification_2")
    println(tableNames.dropRight(10))
  }
}
