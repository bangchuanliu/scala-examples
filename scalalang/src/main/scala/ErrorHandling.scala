package main.scala

object ErrorHandling {

  def main(args: Array[String]): Unit = {
    catches
  }
  
  
  
  def catches() {
    try {
      println(List(1,2,3).drop(3).reduce((x, y) => x / (x+y)))
    }catch { //ignore exception
      case e : Exception => println(e)
    }


    // ignore exception
    scala.util.control.Exception.ignoring(classOf[Exception]) {
      println(List(1,2,3).drop(3).reduce((x, y) => x / (x+y)))
    }
  }
  
}
