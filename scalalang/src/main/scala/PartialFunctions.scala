package main.scala

object PartialFunctions {

  def main(args: Array[String]): Unit = {
    val divide: PartialFunction[Int, Int] = {
      case d: Int if d != 0 => 42 / d
    }

    println(divide.isDefinedAt(1))
    println(divide.isDefinedAt(0))
    println(divide(1))


    println(List(0, 1, 2).collect(divide))
    println(List(0, "cat", 2) collect { case d: Int => d + 1 })

    //    val convertLowNumToString: PartialFunction[Int, String] = {
    //      val nums = Array("one", "two", "three", "four", "five")
    //      def apply(i: Int) = nums(i - 1)
    //      def isDefinedAt(i: Int) = (i > 0 && i < 6)
    //    }
    //
    //    println(convertLowNumToString(1))
  }


}
