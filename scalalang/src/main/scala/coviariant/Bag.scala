package coviariant

class Bag[T] {


  def add(t : T) = println(t)


}

object B {
  def main(args: Array[String]): Unit = {
    val b1 = new Bag[Water]
//    listBagStuff(b1)
  }


  def listBagStuff(bag : Bag[Stuff]) = println(bag)
}
