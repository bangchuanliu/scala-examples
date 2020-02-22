package typetag

import scala.reflect.ClassTag
import scala.reflect.runtime.universe._
import scala.tools.asm.Type

object PatternMatchType {

  def main(args: Array[String]): Unit = {
    val task0 = new Task(1, 2, List())
    val task1 = new Task(1, 2, List("a"))
    val task2 = new Task(1, 2, Seq("a", "b"))

    //    task0.evenOrOdd
    //    task1.evenOrOdd
    //    task0.f(apply0 _)
    println(task0.transform(Transformer.apply0 _))
    println(task1.transform(Transformer.apply0 _))
    println(task1.transform(Transformer.apply2 _))
    println(task2.transform(Transformer.apply2 _))
  }

  class Task(v1: Int, v2: Int, v3: Seq[String]) {

//    type F0 = ((Int, Int) => String)
//    type F1 = ((Int, Int, String) => String)
//    type F2 = ((Int, Int, Seq[String]) => String)

    //    def transform[T](f : T) : String = f match {
    //      case t1 : F0 => t1(v1, v2)
    ////      case t2 : F1  => t2(v1, v2, v3.head)
    //      case t3 : F2  => t3(v1, v2, v3)
    //      case _ => throw new RuntimeException
    //    }


    def transform(f: (Int, Int, String, String, String) => String): String = {
      f(v1,v2,v3(0),v3(1),v3(2))
    }

    def transform(f: (Int, Int) => String): String = {
      f(v1,v2)
    }

    def transform(f: (Int, Int, String) => String): String = {
      f(v1,v2, v3(0))
    }

    def transform(f: (Int, Int, Seq[String]) => String, message : String = "Passing DataFrame as List")(implicit tag: ClassTag[AnyRef]): String = {
      f(v1,v2, v3)
    }

    def transform(f: (Int, Int, String, String) => String): String = {
      f(v1,v2,v3(0),v3(1))
    }


    //    def transform[T](f : T) : String = f match {
    //      case t1 : ((Int, Int) => String) => t1(v1, v2)
    ////      case t2 : ((Int, Int, Int) => String) => t2(v1, v2, v3.head)
    //      case t3 : ((Int, Int, Seq[String]) => String) => t3(v1, v2, v3)
    //      case _ => throw new RuntimeException
    //    }


    //    def viriousParameters(f: (Int, Int, String *) => String): String = {
    //      f(1, 2, "hello")
    //    }

    //    def transform[T](f : T) : String = f match {
    //      case t1 : ((Int, Int) => String) => t1(1, 2)
    //      case t2 : ((Int, Int, String) => String) => t2(1, 2, "a")
    //      case t3 : ((Int, Int, Seq[String]) => String) => t3(1, 2, Seq("a","b"))
    //      case _ => throw new RuntimeException
    //    }
  }

}
