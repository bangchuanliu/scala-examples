package main.scala

import scala.collection.mutable

object DataStructure {
  def main(args: Array[String]): Unit = {
    createDataTypes
  }


  def createDataTypes(): Unit = {
    // all are considered string
    Seq(1, "2", "3", 4, 5.0).map(e => e + "1").foreach(println(_))
    val (a, b) = (1, 2)
    val arr = Array(1, 2, 3, "4")
    val x = 3
    var y = 4

    val map = mutable.Map.empty[Int, Int]
    val map2 = map += (1 -> 2)
  }


}
