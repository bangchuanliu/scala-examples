package scalas

object PartialAppliedFunctions {

  def main(args: Array[String]): Unit = {
    val f = sum(1, 2, _: Int)

    println(f(3))


    val wrapWithDiv = wrap("<div>", _: String, "</div>")

    println(wrapWithDiv("<p>Hello, world</p>"))
    println(wrap("<pre>", "val x = 1", "</pre>"))
  }


  def sum(a: Int, b: Int, c: Int): Int = {
    a + b + c
  }


  def wrap(prefix: String, html: String, suffix: String) = {
    prefix + html + suffix
  }
}
