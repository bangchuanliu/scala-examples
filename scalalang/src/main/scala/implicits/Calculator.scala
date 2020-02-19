package main.scala.implicits

import implicits.StringOps
import main.scala.implicits.CalculatorImplicits._
import implicits.StringImplicits._

object Calculator {

  def main(args: Array[String]): Unit = {
    println(join(3, 5, sum))
    val n1 = new Number(3)
    val n2 = new Number(3)
    println(n1.join(n2, sum))


    println(n1 + n2)
    StringOps.printImplicit
    printImplicit
  }

  def printImplicit(implicit str: String): Unit = {
    println(str)
  }

  def sum(a: Number[Int], b: Number[Int]): Number[Int] = {
    new Number(a.v + b.v)
  }

  def sum(a: Int, b: Int): Int = {
    a + b
  }

  def join(a: Int, b: Int, f: (Int, Int) => Int): Int = {
    f(a, b)
  }
}


