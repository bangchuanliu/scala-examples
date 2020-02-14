package scalas.traits.mixin

abstract class IntQueue {
  def put(x: Int)

  def get(): Int
}
