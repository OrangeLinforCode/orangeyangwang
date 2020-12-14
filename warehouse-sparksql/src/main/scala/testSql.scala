package src.main.scala

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
 * @Description:
 * @author oranglzc
 * @creat 2020-12-12-0:02
 */
object testSql {
  def main(args: Array[String]): Unit = {



  readNetwork




  }
  def readNetwork: Unit ={
    val file=scala.io.Source.fromURL("https://www.baidu.com/")
    for(line<-file.getLines()){
      println(line)
    }
  }

  def dealQuery(str:String)={


    val spark: SparkSession = initEnv()


    logiceProcess(spark,str)


    stop(spark)
  }


  def initEnv() ={
    val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("Spark_LoadHive2")

    val spark: SparkSession = SparkSession.builder().enableHiveSupport()
      .config(sparkConf).getOrCreate()

    spark
  }

  def stop(spark:SparkSession): Unit ={
   spark.stop()
  }


  def logiceProcess(spark: SparkSession,sql:String) ={
    spark.sql(sql)
  }
}
