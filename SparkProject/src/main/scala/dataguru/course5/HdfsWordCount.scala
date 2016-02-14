package dataguru.course5

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * Hdfs文件演示
 * Created by liguodong on 2016/2/6.
 */
object HdfsWordCount {

  def main(args: Array[String]) {

    // Create a local StreamingContext with two working thread and batch interval of 20 second.
    // The master requires 2 cores to prevent from a starvation scenario.
    val sparkConf = new SparkConf().setAppName("HdfsWordCount").setMaster("local[2]")

    // Create the context
    val ssc = new StreamingContext(sparkConf, Seconds(20))//20s对数据处理一次

    val lines = ssc.textFileStream("/home/mmicky/temp/") //需要监视的目录
    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }

}
