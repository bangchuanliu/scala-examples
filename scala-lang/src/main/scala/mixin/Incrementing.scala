package main.scala.mixin

trait Incrementing extends IntQueue {

  abstract override def put(x: Int): Unit = super.put(x + 1)
}
