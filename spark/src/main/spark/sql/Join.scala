package sql

import sql.Select.User
import utils.SparkUtil.spark

object Join {
  import spark.implicits._
  
  case class AggregatedInsightTagEvents(viewerCompanyId: Long,
                                        viewerFunctionId: Long,
                                        viewerGeoEntityId: Long,
                                        viewerSeniorityId: Long,
                                        insightTagId: Long,
                                        totalViews: Long)

  case class ContractToInsightTagMapping(contractId: Long, insightTagId: Long)

  def main(args: Array[String]): Unit = {
    joinByColumn
  }

  def joinByColumn(): Unit = {
    val cc =
      List(
        ContractToInsightTagMapping(188, 1),
        ContractToInsightTagMapping(288, 1)
      ).toDS()

    val sv = List(
      AggregatedInsightTagEvents(11, 1, 1, 1, 1, 1),
      AggregatedInsightTagEvents(12, 1, 1, 1, 1, 1)
    ).toDS()

    val df = sv
      .join(cc, sv("insightTagId") <=> cc("insightTagId"), "inner")
      .select(
        "viewerCompanyId",
        "viewerFunctionId",
        "viewerGeoEntityId",
        "viewerSeniorityId",
        "contractId",
        "totalViews"
      )
    
    df.show(false)
  }


  def joinDS():Unit = {
    val df1 = List(User("kevin", 21), User("peter", 32)).toDF
    val df2 = List(User("kevin", 21), User("jason", 33)).toDF

    df1.join(df2).show(false)
    df1.except(df2).show(false)
    df1.join(df2, Seq("name"), "inner")
  }
}
