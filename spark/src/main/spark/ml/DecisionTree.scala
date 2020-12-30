package ml

import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.feature.{Binarizer, VectorAssembler}
import utils.SparkUtil.spark

object DecisionTree {
  
  def main(args: Array[String]): Unit = {
    decisionTree
  }

  def decisionTree():Unit = {
    val df = spark.read.format("org.apache.spark.csv").option("header", true).option("inferSchema", true).csv("/Users/liubangchuan/data/coursea-bigdata/daily_weather.csv")
    val df2 = df.drop("number").na.drop()
    val binarizerDF = new Binarizer().setThreshold(24.99999).setInputCol("relative_humidity_3pm").setOutputCol("label").transform(df2)
    binarizerDF.select("relative_humidity_3pm", "label").show(4)
    val featureColumns = Array("air_pressure_9am", "air_temp_9am", "avg_wind_direction_9am", "avg_wind_speed_9am", "max_wind_direction_9am", "max_wind_speed_9am", "rain_accumulation_9am", "rain_duration_9am")
    val assembler = new VectorAssembler().setInputCols(featureColumns).setOutputCol("features")
    val assembled = assembler.transform(binarizerDF)
    val Array(trainingData, testData) = assembled.randomSplit(Array(0.7, 0.3), 13234)
    println(trainingData.count())
    println(testData.count())

    val dt = new DecisionTreeClassifier().setLabelCol("label").setFeaturesCol("features").setMaxDepth(5).setMinInstancesPerNode(20).setImpurity("gini")
    val pipeline = new Pipeline().setStages(Array(dt))
    val model = pipeline.fit(trainingData)
    val predictions = model.transform(testData)

    predictions.select("prediction", "label").show(20)
  }
}
