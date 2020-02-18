package main.scala.implicits

object CalculatorImplicits {

  implicit def wrapper[T](x : Number[T]) : RichNumber[T] = new RichNumber(x)

//  implicit def NumberToT[T](x : Number[T]) : T = x.v
implicit def NumberToInt[Int](x : Number[Int]) : Integer = 1

  implicit def NumberToDouble[Int](x : Number[Int]) : Double = 2


}
