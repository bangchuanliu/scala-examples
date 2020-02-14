package scalas.traits.mixin

trait Doubling extends IntQueue {

  abstract override def put(x: Int): Unit = super.put(x * 2)
}
