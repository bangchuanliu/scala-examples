package implicits

object StringOps {

  def printImplicit(implicit str: String): Unit = println(str)

  def callImplicits(implicit str: String, str2: String) = println(str + str2)

  def load = loadWithDefaultParam(_: String, _: String, "default", "default")

  def loadWithDefaultParam(path1: String, path2: String, param1: String, param2: String) = {
    println(s"$path1, $path2, $param1, $param2")
  }
}
