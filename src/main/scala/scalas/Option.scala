package scalas

object Option {
  def main(args: Array[String]): Unit = {
    flattenOption
    reduceOption
  }

  def flattenOption(): Unit = {
    // None is removed after flatten
    List(Some(1), None, Some(2)).flatten.foreach(print(_)) //12

    // use option map or option foreach versus get, getOrElse
    Some(1).foreach(println(_)) // 1
    None.foreach(println(_))

    // use map
    Some(1).map(_ * 2).foreach(println(_))
  }

  def reduceOption(): Unit = {
    // throw exception
    //    println(List(1,2,3).drop(3).reduce((x, y) => x / (x+y)))

    // use option
    List(1, 2, 3).drop(3).reduceOption((x, y) => x / (x + y)).foreach(println(_))
  }


  def optionWithFunction(): Unit = {
    val name = Some("kevin")
    val ret = name map (_.trim) filter (_.length > 0) map (_.toUpperCase)
    ret.foreach(println)
  }
  

}
