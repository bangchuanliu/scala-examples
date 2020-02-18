package main.scala

object NewtonsMethod {

  def main(args: Array[String]): Unit = {
    drive
  }


  def drive: Unit = {
    val f = (x: Double) => 3 * x + math.sin(x) - math.pow(math.E, x)
    val fx = (x: Double) => 3 + math.cos(x) - math.pow(Math.E, x)

    val initialGuess = 0
    val tolerance = 0.0000000001

    println(newtonsMethod(f, fx, initialGuess, tolerance))
  }


  def newtonsMethod(f: Double => Double, fx: Double => Double, x: Double, tolerance: Double): Double = {
    var x1 = x
    var xNext = newtonsMethodHelper(f, fx, x1)

    while (Math.abs(x1 - xNext) > tolerance) {
      x1 = xNext
      xNext = newtonsMethodHelper(f, fx, x1)
    }
    xNext
  }

  def newtonsMethodHelper(f: Double => Double, fx: Double => Double, x: Double): Double = {
    x - f(x) / fx(x)
  }
}
