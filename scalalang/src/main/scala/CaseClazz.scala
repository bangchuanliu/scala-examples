package main.scala

object CaseClazz {
  def main(args: Array[String]): Unit = {
    val s = Student("kevin", 21)
    val t = Teacher("john", "US")
    
    getPerson(s)
    getPerson(t)
  }

  def getPerson(p : Person) ={
    p match {
      case Student(name, age) => println(s"student: name is $name, age is $age")
      case Teacher(name, address) => println(s"teacher: name is $name, address is $address")
    }
  }
}

case class Student(name: String, age: Int) extends Person

case class Teacher(name: String, address: String) extends Person

trait Person {
  def name: String
}
