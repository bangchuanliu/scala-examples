package ml

import org.apache.parquet.it.unimi.dsi.fastutil.Arrays
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.{Binarizer, VectorAssembler}
import org.apache.spark.mllib.evaluation.MulticlassMetrics
import org.apache.spark.sql.functions.col
import utils.SparkUtil.spark

object DecisionTree {

  def main(args: Array[String]): Unit = {
//    decisionTree
//        predictions
    minuteWeather
  }

  def minuteWeather():Unit = {
    import spark.implicits._
    
    val df = spark.read.format("org.apache.spark.csv").option("header", true).option("inferSchema", true).csv("/Users/liubangchuan/data/coursea-bigdata/big-data-4/minute_weather.csv")
    val filterDF = df.filter($"rowID" % 10 === 0)
    df.describe()
    
    val rainAccumulation = filterDF.filter($"rain_accumulation" === 0.0)
    val rainDuration = filterDF.filter($"rain_duration" === 0.0)
    
    val workingDF = filterDF.drop("rain_accumulation", "rain_duration", "hpwren_timestamp").na.drop()
  }

  def predictions(): Unit = {
    val df = spark.read.format("org.apache.spark.csv").option("header", true).option("inferSchema", true).csv("/Users/liubangchuan/data/coursea-bigdata/predictions.csv")
    val evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction").setMetricName("accuracy")
    val accuracy = evaluator.evaluate(df)
    println(s"Accuracy = ${accuracy}")
    val metrics = new MulticlassMetrics(df.rdd.map(row => Tuple2(row.getDouble(0), row.getDouble(1))))
    println(metrics.confusionMatrix.toArray.mkString(","))
  }

  def decisionTree(): Unit = {
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

//    predictions.select("prediction", "label").show(20)
    predictions.select("prediction", "label").write
      .mode("overwrite")
      .format("com.databricks.spark.csv")
      .option("header", true)
      .save("/Users/liubangchuan/data/coursea-bigdata/predictions.csv")
  }
}
