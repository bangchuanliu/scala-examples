package scalas

object Functions {

  // implicit return types
  val toUpperCase2 = (s: String) => s.toUpperCase

  // explicit return types
  val toUpperCase: String => String = _.toUpperCase
  val append: (String, String) => String = _ + _
//  val toUpperCaseThenAppend = toUpperCase.andThen(append(_, "@gmail.com"))

  val double = (i : Int) => {i * 2}
  
  def main(args: Array[String]): Unit = {
//    println(toUpperCaseThenAppend("kevin"))

    println(double(2))
  }
}
