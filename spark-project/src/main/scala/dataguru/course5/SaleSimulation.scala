package dataguru.course5

import java.io.PrintWriter
import java.net.ServerSocket

import scala.io.Source

/**
 *  销售模拟器：参数1：读入的文件；参数2：端口；参数3：发送时间间隔ms
 *  打包的时候注意，可以将应用的jar包打进去；
 *  也可以修改classpath，注意每个jar包用空格隔开，如：
 *  /app/scala2104/lib/scala-swing.jar /app/scala2104/lib/scala-library.jar /app/scala2104/lib/scala-actors.jar
 *  测试：
 *  java -cp SaleSimulation.jar dataguru.course5.SaleSimulation /home/mmicky/data/spark/people.txt 9999 1000
 * Created by liguodong on 2016/2/6.
 */
object SaleSimulation {
  def index(length: Int) = {
    import java.util.Random
    val rdm = new Random

    rdm.nextInt(length)
  }

  def main(args: Array[String]) {
    if (args.length != 3) {
      System.err.println("Usage: <filename> <port> <millisecond>")
      System.exit(1)
    }

    val filename = args(0)
    val lines = Source.fromFile(filename).getLines.toList
    val filerow = lines.length

    val listener = new ServerSocket(args(1).toInt)

    while (true) {
      val socket = listener.accept()
      new Thread() {
        override def run = {
          println("Got client connected from: " + socket.getInetAddress)
          val out = new PrintWriter(socket.getOutputStream(), true)
          while (true) {
            Thread.sleep(args(2).toLong)

            val content = lines(index(filerow))//读取随机的一行

            println(content)
            out.write(content + '\n')
            out.flush()
          }
          socket.close()
        }
      }.start()
    }
  }
}
