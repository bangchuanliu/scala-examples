package scalas.implicits

class Number[T](val v: T) {

  override def toString: String = v.toString
}
