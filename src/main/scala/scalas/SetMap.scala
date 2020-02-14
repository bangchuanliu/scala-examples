package scalas

import scala.collection.mutable


object SetMap {
  def main(args: Array[String]): Unit = {
    val s1 = Set(1,2,3)
    val s2 = mutable.Set(1,2,3)
    val s11 = s1 + 4
    val s22 = s2 += 4
    
    val m1 = Map(
      1 -> "a",
      2 -> "b"
    )
    
    val m2 = mutable.Map(
      1 -> "a",
      2 -> "b"
    )
    
    val m11 = m1 + (3 -> "c")
    val m22 = m2 += (3 -> "c")
  }
}
