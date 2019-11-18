package scalas

object OptionDemo {
  def main(args: Array[String]): Unit = {
    printOption
  }
  
  def printOption(): Unit = {
    val list = List(Some(1), None, Some(2))
    list.flatten.foreach(print(_)) //12

    val list2 = List(Some(1), None, None)
    list2.flatten.foreach(print(_)) //1

    val list3 = List(None, None, None)
    list3.flatten.foreach(print(_)) //

    println
    val o1 = Some(1)
    val o2 = None
    
    o1.foreach(println((_)))
    o2.foreach(println((_)))
  }
  
  
  
  

}
