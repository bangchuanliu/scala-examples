package encoder

/**
 *  case class and scala primitive object can use spark.implicits._
 *  customer object need explicit encoder see {@link Encoder}
 */


/**
 * 1. val means constructor parameters are public
 * 2. extends Serializable to serialize and deserialize 
 * 
 * @param food
 * @param price
 */
class Order(val food: String, val price: Double) extends Serializable

class Menu(val food : String) extends Serializable
