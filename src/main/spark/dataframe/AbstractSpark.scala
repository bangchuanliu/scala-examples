package dataframe

class AbstractSpark {
  protected val spark = SparkSession.builder
    .master("local")
    .appName("spark-examples")
    .getOrCreate()
}
