package scalas.traits.`with`

//class BasicJob extends AbstractJob with Job {
//
//  override def transform(jobParam: Array[String]): Int = 1
//}

object BasicJob extends Job {
  override def transform(jobParam: Array[String]): Int = 2
}
