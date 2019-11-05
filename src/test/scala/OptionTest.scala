import org.scalatest._
import Matchers._
import org.junit.Test

class OptionTest {
  def main(args: Array[String]): Unit = {
    
  }


  @Test
  def compareOption(): Unit = {
    val num = List(Some(1), None, Some(2)).flatten.sum
    num shouldBe 3
  }
}
