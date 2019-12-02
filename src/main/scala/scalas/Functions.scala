package scalas

object Functions {

  val toUpperCase: String => String = _.toUpperCase
  val append: (String, String) => String = _ + _
  val toUpperCaseThenAppend = toUpperCase.andThen(append(_, "@gmail.com")) 
  
  
  def main(args: Array[String]): Unit = {
    println(toUpperCaseThenAppend("kevin"))
  }
}
