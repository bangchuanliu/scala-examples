package implicits

object StringOps {

  def printImplicit(implicit str : String) : Unit = println(str)
  
}
