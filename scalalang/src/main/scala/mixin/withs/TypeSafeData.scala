package mixin.withs

class TypeSafeData extends AnyRef with TypeUnsafeDataLoader{

  override var seq: Seq[Int] = Seq()
}

object TypeSafeData extends TypeSafeData {
  def main(args: Array[String]): Unit = {
    val d1 = new TypeSafeData
    d1.seq = (d1.seq :+ 1)
    val d2 = new TypeSafeData
    d2.seq = d2.seq :+ 2

    println(d1.seq)
    println(d2.seq)

    d1.load()
    d2.load()

    println(d1.seq)
    println(d2.seq)
  }
}


