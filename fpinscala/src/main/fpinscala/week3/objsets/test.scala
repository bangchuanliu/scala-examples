package objsets

object test {
  def main(args: Array[String]): Unit = {
    val google = List("android", "Android", "galaxy", "Galaxy", "nexus", "Nexus")
    val s = "This $50 stick turns any HDTV into an Android-powered smart TV: http://t.co/8FpZUnIE\", \"retweets"
    println(google.exists(str => s.contains(str)))
  }
}
