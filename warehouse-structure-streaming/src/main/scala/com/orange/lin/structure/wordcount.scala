package com.orange.lin.structure

import org.apache.spark.sql.streaming.Trigger
import org.apache.spark.sql.{DataFrame, SparkSession}

/**
 * @Description:
 * @author oranglzc
 * @creat 2020-12-19-22:01
 */
object wordcount {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder().master("local[4]")
      .appName("wordcount").getOrCreate()

    import spark.implicits._
    //读取数据源
    val lines: DataFrame = spark.readStream.format("socket")
      .option("host", "hadoop109")
      .option("port", 9999)
      .load


    //transoform
    val wordCount=lines.as[String].flatMap(_.split(" ")).groupBy("value").count()
    //输出测试
    val result=wordCount.writeStream
      .format("console")
      .outputMode("update")// complete  append  update
      .trigger(Trigger.ProcessingTime("2 seconds"))
      .start()

    result.awaitTermination()

    spark.close()

  }
}
