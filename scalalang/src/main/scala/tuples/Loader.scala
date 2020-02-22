package tuples

object Loader {

  def main(args: Array[String]): Unit = {
    println(tupleParam((1,2)))
  }



  def tupleParam(v : (Int, Int)) : Int = v._1 + v._2
}
