package typetag

object Transformer {

  def apply0(v1: Int, v2: Int): String = {
    v1 + v2 + ""
  }

  def apply1(v1: Int, v2: Int, s: String): String = {
    v1 + v2 + "" + s
  }

  def apply2(v1: Int, v2: Int, strs: Seq[String]): String = {
    v1 + v2 + "" + strs
  }
}
