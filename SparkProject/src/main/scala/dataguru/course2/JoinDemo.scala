package dataguru.course2

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by liguodong on 2015/12/23.
 */
object JoinDemo {
  def main(args: Array[String]) {
    if(args.length<2){
      System.err.println("Usage:JoinDemo <file1> <file2>")
      System.exit(1)
    }

    val conf = new SparkConf().setAppName("JoinDemo")
    val sc = new SparkContext(conf)

    val format = new java.text.SimpleDateFormat("yyyy-MM-dd")
    case class Register (d: java.util.Date, uuid: String, cust_id: String, lat: Float,lng: Float)
    case class Click (d: java.util.Date, uuid: String, landing_page: Int)
    //"hdfs://localhost:9000/liguodong/join/reg.tsv"
    val reg = sc.textFile(args(0)).map(_.split("\t")).map(r =>
      (r(1), Register(format.parse(r(0)), r(1), r(2), r(3).toFloat, r(4).toFloat)))
    //"hdfs://localhost:9000/liguodong/join/clk.tsv"
    val clk = sc.textFile(args(1)).map(_.split("\t")).map(c =>
      (c(1), Click(format.parse(c(0)), c(1), c(2).trim.toInt)))

    reg.join(clk).take(2).foreach(println)

    sc.stop()

  }
}
