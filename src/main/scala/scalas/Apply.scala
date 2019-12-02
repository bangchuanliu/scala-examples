package scalas


object Apply {

  def main(args: Array[String]): Unit = {
//    Apply("kevin", 21)

    val raw = ""

    raw match {
      case Apply(name, age) => println(s"name = ${name}, age = ${age}")
      case r@_ => print(s"failure to extract, $r")
    }
  }


  def apply(name: String, age: Int): Unit = {
    println(s"name = ${name}, age = ${age}")
  }

  def unapply(rawString: String): Option[(String, Int)] = {
    if (rawString != null && rawString.length > 0) {
      val part = rawString.split(",")
      Some(part(0), part(1).toInt)
    } else {
      None
    }
  }
}
