package dataguru.course2

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by liguodong on 2015/12/23.
 */

object SogouQA {

  def main(args: Array[String]) {
    if(args.length<2){
      System.err.println("Usage:SogouQA <file1> <file2>")
      System.exit(1)
    }

    val conf = new SparkConf().setAppName("SogouQA")
    val sc = new SparkContext(conf)

    sc.textFile(args(0)).map(_.split("\t")).filter(_.length==6)
      .map(x=>(x(1),1)).reduceByKey(_+_)
      .map(x=>(x._2,x._1)).sortByKey(false)
      .map(x=>(x._2,x._1)).saveAsTextFile(args(1))

    sc.stop()

  }
}
