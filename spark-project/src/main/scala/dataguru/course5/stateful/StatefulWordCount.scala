package dataguru.course5.stateful

import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by liguodong on 2016/2/7.
 */
object StatefulWordCount {
  def main(args: Array[String]) {

    val updateFunc = (values: Seq[Int], state: Option[Int]) => {
      val currentCount = values.foldLeft(0)(_ + _)
      val previousCount = state.getOrElse(0)
      Some(currentCount + previousCount)
    }

    val conf = new SparkConf().setAppName("StatefulWordCount").setMaster("local[2]")
    val sc = new SparkContext(conf)

    //创建StreamingContext
    val ssc = new StreamingContext(sc, Seconds(5))
    ssc.checkpoint(".")//当前目录

    //获取数据
    val lines = ssc.socketTextStream(args(0), args(1).toInt)
    val words = lines.flatMap(_.split(","))
    val wordCounts = words.map(x => (x, 1))

    //使用updateStateByKey来更新状态
    val stateDstream = wordCounts.updateStateByKey[Int](updateFunc)
    stateDstream.print()

    ssc.start()
    ssc.awaitTermination()
  }
}
