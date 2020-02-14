package scalas.implicits

class RichNumber[T](val v : Number[T]) {

  def join[U, K](other: Number[U], f: (Number[T], Number[U]) => Number[K]): Number[K] = {
    f(v, other)
  }
}
