package main.scala.mixin

trait Filtering extends IntQueue {

  abstract override def put(x: Int): Unit = if (x > 0) super.put(x)
}
