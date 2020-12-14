package src.main.scala.receiver

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @Description:
 * @author oranglzc
 * @creat 2020-12-13-22:23
 */
object socket_stream {
  def main(args: Array[String]): Unit = {
    val sparkConf: SparkConf = new SparkConf().setMaster("local[2]").setAppName("stream")

    //    val ssc = new StreamingContext(sparkConf,Duration(3000))
    //Duration的构造传入参数单位为毫秒，可以通过其他
    val ssc = new StreamingContext(sparkConf,Seconds(3))


  }
}
