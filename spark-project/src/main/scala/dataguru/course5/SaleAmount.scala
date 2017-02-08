package dataguru.course5

import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkConf, SparkContext}

/**
 * 无状态的操作
 *
 * sale数据演示
 * qryStockDetail.txt文件定义了订单明细
 * 订单号，行号，货品，数量，单价，金额
 * 使用方法：java -cp SaleAmount.jar dataguru.course5.window.SaleSimulation
 * /home/mmicky/data/spark/saled    ata/qryStockDetail.txt 9999 100
 *
 * Created by liguodong on 2016/2/7.
 */
object SaleAmount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("SaleAmount").setMaster("local[2]")
    val sc = new SparkContext(conf)

    //每5秒钟销售总额
    val ssc = new StreamingContext(sc, Seconds(5))

    val lines = ssc.socketTextStream(args(0), args(1).toInt, StorageLevel.MEMORY_AND_DISK_SER)

    //异常数据清洗
    val words = lines.map(_.split(",")).filter(_.length == 6)

    //取出第六列
    val wordCounts = words.map(x=>(1, x(5).toDouble)).reduceByKey(_ + _)

    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }
}