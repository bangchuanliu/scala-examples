package encoder

import scala.reflect.ClassTag
import org.apache.spark.sql.{Encoder, Encoders}

object EncoderUtils {

  /**
   * This encoder maps T into a single byte array (binary) field.
   */
  implicit def single[A](implicit c: ClassTag[A]): Encoder[A] = Encoders.kryo[A](c)

  implicit def tuple2[A1, A2](
                               implicit e1: Encoder[A1],
                               e2: Encoder[A2]
                             ): Encoder[(A1, A2)] = Encoders.tuple[A1, A2](e1, e2)

  implicit def tuple3[A1, A2, A3](
                                   implicit e1: Encoder[A1],
                                   e2: Encoder[A2],
                                   e3: Encoder[A3]
                                 ): Encoder[(A1, A2, A3)] = Encoders.tuple[A1, A2, A3](e1, e2, e3)
}
