package main.scala

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

    exec(sayHello, "kevin")

    execClosure(Closures.isVotingAge, 21)
    execClosure(Closures.isVotingAge, 16)
    Closures.votingAge = 15
    execClosure(Closures.isVotingAge, 16)

    val sayHi = saySomething("HI")
    println(sayHi("AI"))
  }


  def exec(f: String => Unit,  name : String): Unit = {
    f(name)
  }

  val hello = "hello"

  def sayHello(name : String): Unit = {
    println(s"$hello, $name")
  }

  def execClosure(f: Int => Boolean, age: Int): Unit = {
    println(f(age))
  }

  // function return a function
  def saySomething(prefix: String): String => String = {
    (s : String) => prefix + " " + s
  }
}
