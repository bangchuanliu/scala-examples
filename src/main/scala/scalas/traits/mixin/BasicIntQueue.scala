package scalas.traits.mixin

import scala.collection.mutable.ListBuffer

/**
  *  traits mixin example
  *
  */
class BasicIntQueue extends IntQueue {

  val buffer: ListBuffer[Int] = ListBuffer()

  override def put(x: Int): Unit = buffer.append(x)

  override def get(): Int = buffer.remove(0)
}

object BasicIntQueue {

  def main(args: Array[String]): Unit = {
    withIncrementingAndDoubling
  }

  def default() = {
    val q = new BasicIntQueue
    q.put(1); q.put(2); q.put(3)
    println(q.get()); println(q.get()); println(q.get())
  }

  def withIncrementing() = {
    val q = new BasicIntQueue with Incrementing
    q.put(1); q.put(2); q.put(3)
    println(q.get()); println(q.get());println(q.get())

  }

  def withIncrementingAndDoubling() = {
    val q = new BasicIntQueue with Incrementing with Doubling
    q.put(1); q.put(2);
    println(q.get()); println(q.get())

  }
}
