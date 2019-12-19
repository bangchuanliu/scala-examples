package scalas


object ApplyUnApply {

  def main(args: Array[String]): Unit = {
    ApplyUnApply("kevin", 21)
    
    val raw = "kevin, 22"
    raw match {
      case ApplyUnApply(name, age) => println(s"Unapply example : name = ${name}, age = ${age}")
      case r@_ => print(s"failure to extract, $r")
    }
  }


  // implicitly call in instance
  def apply(name: String, age: Int): Unit = {
    println(s"Apply example : name = ${name}, age = ${age}")
  }
  
  // for extractors
  def unapply(rawString: String): Option[(String, Int)] = {
    if (rawString != null && rawString.length > 0) {
      val part = rawString.split(",")
      Some(part(0), part(1).trim.toInt)
    } else {
      None
    }
  }
}
