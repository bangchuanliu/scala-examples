package futures

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object Futures {
  def main(args: Array[String]): Unit = {
    singleFuture
    println("-----------------------------------------------------------------------------")
    multiFutures
  }


  def multiFutures() = {
    val f1 = Future {
      Thread.sleep(Random.nextInt(1000))
      "I"
    }

    val f2 = Future {
      Thread.sleep(Random.nextInt(1000))
      "Love"
    }

    val f3 = Future {
      Thread.sleep(Random.nextInt(1000))
      "China"
    }

    val result = for {
      r1 <- f1
      r2 <- f2
      r3 <- f3
    } yield s"$r1 $r2 $r3"

    result.foreach(value => println(s"result is $value"))
    println("A....")
    Thread.sleep(200)
    println("B....")
    Thread.sleep(200)
    println("C....")
    Thread.sleep(200)
    println("D....")
    Thread.sleep(200)
    println("E....")
    Thread.sleep(200)
  }




  def singleFuture() = {
    val f1: Future[Int] = Future {
      Thread.sleep(Random.nextInt(1000))
      val value = Random.nextInt(10)
      value
    }

    // blocking call
    val ret = Await.result(f1, Duration.Zero)
    println(s"f1: blocking call : value is $ret")

    // non-blocking call onComplete
    val f2: Future[Int] = Future {
      Thread.sleep(Random.nextInt(1000))
      val value = 10 + Random.nextInt(10)
      value
    }

    f2 onComplete {
      case Success(value) => println(s"f2 : Got the callback : value is $value")
      case Failure(exception) => println(s"f2 : Got exception is $exception")
    }

    // functional programming
    val f3: Future[Int] = Future {
      Thread.sleep(Random.nextInt(1000))
      val value = 20 + Random.nextInt(10)
      value
    }

    f3.map(_ * 2).foreach(value => println(s"f3 : value is $value"))

    // waiting for futures to complete
    println("A....")
    Thread.sleep(200)
    println("B....")
    Thread.sleep(200)
    println("C....")
    Thread.sleep(200)
    println("D....")
    Thread.sleep(200)
    println("E....")
    Thread.sleep(200)
  }
}
