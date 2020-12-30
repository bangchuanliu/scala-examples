package dataframe

import java.util.Date
import models.Models.Notification
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.sql.functions._
import utils.SparkUtil._
import org.apache.spark.ml.feature.Binarizer
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.VectorIndexer

object SparkDateFrame {

  import spark.implicits._

  def main(args: Array[String]): Unit = {
//    splitColumn
    //    dateOp
  }

  def agg(): Unit = {
    val df = spark.read.format("org.apache.spark.csv").option("header", true).option("inferSchema", true).csv("/Users/liubangchuan/data/coursea-bigdata/daily_weather.csv")
    val imputeDF = df
    val removedNullDF = df.na.drop()
    for(x <- imputeDF.columns) {
      val meanValue = removedNullDF.agg(avg(x)).first().getDouble(0)
      println(x, meanValue)
      imputeDF.na.fill(meanValue, Array(x))
    }
  }

  val data = List(
    Notification("urn:li:member:87160834", "urn:li:contract:18615004", "urn:li:salesPotentialBuyerNotification:(urn:li:seniority:1,urn:li:function:-1,urn:li:geo:100027885,urn:li:organization:1035)", new Date().getTime - 1000 * 3600 * 12),
    Notification("urn:li:member:87160834", "urn:li:contract:18615004", "urn:li:salesPotentialBuyerNotification:(urn:li:seniority:2,urn:li:function:-1,urn:li:geo:100027885,urn:li:organization:1035)", new Date().getTime - 1000 * 3600 * 12),
    Notification("urn:li:member:87160834", "urn:li:contract:18615005", "urn:li:salesPotentialBuyerNotification:(urn:li:seniority:3,urn:li:function:2,urn:li:geo:100027885,urn:li:organization:1036)", new Date().getTime - 1000 * 3600 * 72),
    Notification("urn:li:member:87160834", "urn:li:contract:18615005", "urn:li:salesPotentialBuyerNotification:(urn:li:seniority:4,urn:li:function:2,urn:li:geo:100027885,urn:li:organization:1035)", new Date().getTime - 1000 * 3600 * 96),
    Notification("urn:li:member:87160834", "urn:li:contract:18615005", "urn:li:salesPotentialBuyerNotification:(urn:li:seniority:5,urn:li:function:2,urn:li:geo:100027885,urn:li:organization:1035)", new Date().getTime - 1000 * 3600 * 24 * 10)
  )

  def dateOp() = {
    //    data.toDF.select(date_sub(to_date(from_unixtime($"time"/1000)), 1)).show
    data.toDF.filter(to_date(from_unixtime($"notificationTime" / 1000)) > date_sub(current_date(), 1)).show()
  }

  def splitColumn(): Unit = {
    val df = data.toDF().select($"recipientMemberUrn", $"recipientContractUrn",
      regexp_extract($"entityUrn", ".*:seniority:(.{0,5}),.*", 1).alias("seniority"),
      regexp_extract($"entityUrn", ".*:function:(.{0,5}),.*", 1).alias("function"),
      regexp_extract($"entityUrn", ".*:geo:(.{0,50}),.*", 1).alias("geo"),
      regexp_extract($"entityUrn", ".*:organization:(.{0,50})\\).*", 1).alias("organization")
    )

    df.groupBy("recipientMemberUrn", "recipientContractUrn").count().sort("count")
      .show(false)

    def splitColumn(): Unit = {
      val df = data.toDF().select($"recipientMemberUrn", $"recipientContractUrn",
        regexp_extract($"entityUrn", ".*:seniority:(.{0,5}),.*", 1).alias("seniority"),
        regexp_extract($"entityUrn", ".*:function:(.{0,5}),.*", 1).alias("function"),
        regexp_extract($"entityUrn", ".*:geo:(.{0,50}),.*", 1).alias("geo"),
        regexp_extract($"entityUrn", ".*:organization:(.{0,50})\\).*", 1).alias("organization")
      )
    }
    // union and dedupe
    //    d1.union(d2).distinct().show()
    //
    //    // left anti
    //    d1.join(d2, Seq("value"), "left_anti").show()
    //    df.groupBy("recipientMemberUrn", "recipientContractUrn").count().sort("count")
    //      .show(false)

    //   val df1 = df.groupBy("recipientMemberUrn", "recipientContractUrn")
    //      .agg(
    //        count("*").alias("cnt"),
    //        max("cnt").as("maxCnt")
    //      )
    //      .sort("recipientMemberUrn", "recipientContractUrn","cnt")
    //     .show(false)

    //  val df2 =  
    //    df.groupBy("recipientMemberUrn", "recipientContractUrn","organization")
    //      .count
    //      .sort("recipientMemberUrn", "recipientContractUrn","organization","count")
    //      .withColumnRenamed("count", "memberContractOrg")
    //      .withColumn("memberContractOrgGeo", lit(0))
    //      .withColumn("memberContractOrgGeoFun", lit(0))
    //
    //  val df3 =   df.groupBy("recipientMemberUrn", "recipientContractUrn","organization", "geo")
    //    .count
    //    .sort("recipientMemberUrn", "recipientContractUrn","organization","geo","count")
    //    .withColumnRenamed("count", "memberContractOrgGeo")
    //    .withColumn("memberContractOrgGeoFun", lit(0))

    //df.groupBy("recipientMemberUrn", "recipientContractUrn","organization", "geo", "function")
    //  .count
    //  .sort("recipientMemberUrn", "recipientContractUrn","organization","geo","function","count")
    //  .withColumnRenamed("count", "memberContractOrgGeoFun")
    //  .show(false)
    //
    //
    //    df.groupBy("recipientMemberUrn", "recipientContractUrn","organization", "geo", "function")
    //      .count
    //      .sort("recipientMemberUrn", "recipientContractUrn","organization","geo","function","count")
    //      .coalesce(1).write.mode(SaveMode.Overwrite).option("header", "true").csv("data/spark/1")


    def highOrderFunction(): Unit = {
      import spark.implicits._

      spark.range(2).toDF().show

      println(spark.range(5).toDF.schema)

      val d1 = Seq(1, 2, 3, 4, 5).toDF()
      val d2 = Seq(1, 3, 5, 7).toDF()

      // except
      d1.except(d2).show()

      // union
      d1.union(d2).show()

      // union and dedupe
      d1.union(d2).distinct().show()

      // left anti
      d1.join(d2, Seq("value"), "left_anti").show()
    }

    case class Person(name: String, age: Int)

    def writeFile() = {
      val data = spark.read.json("src/main/resources/urn.json")
      data.write.format("avro").save("p.avro")
    }
  }
}
