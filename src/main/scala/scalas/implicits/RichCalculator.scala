package scalas.implicits

class RichCalculator[T](val self : T) {

  def join(a: T, f: (T, T) => T): T = {
    f(a, self)
  }
}
