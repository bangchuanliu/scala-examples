package main.scala.mixin

abstract class IntQueue {
  def put(x: Int)

  def get(): Int
}
