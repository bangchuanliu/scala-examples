package scalas.traits.`with`

trait Job {
  protected val read = Map((1 -> 2))

  implicit val value = 3

  def transform(jobParam : Array[String]) : Int

  def main(args: Array[String]): Unit = {
    println(transform(args))
  }
}
