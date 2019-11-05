package scalas

object DataTypes {
  def main(args: Array[String]): Unit = {
    createDataTypes
  }
  
  
  
  def createDataTypes(): Unit ={
    // all are considered string
    Seq(1, "2", "3", 4, 5.0).map(e => e + "1").foreach(println(_))
    
    val (a, b) = (1,2)
    
    val arr = Array(1,2,3,"4")
    
    val x = 3
    var y = 4
  }
}
