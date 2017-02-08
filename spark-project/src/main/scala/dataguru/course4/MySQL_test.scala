package dataguru.course4

import java.sql.{ResultSet, DriverManager}

/**
 * Created by liguodong on 2016/2/6.
 */
object MySQL_test{
  def main(args: Array[String]) {

    Class.forName("com.mysql.jdbc.Driver")
    val conn = DriverManager.getConnection("jdbc:mysql://hadoop3:3306/test", "hadoop", "hadoop")
    try {

      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE )
      val prep=conn.prepareStatement("insert into saledata (theyear,qty,amount) values (\"2003\",2,3)")
      prep.executeUpdate()
      val rs = statement.executeQuery("select theyear,qty,amount from saledata")
      while (rs.next) {
        val theyear = rs.getString("theyear")
        val qty = rs.getString("qty")
        println("theyear = %s, qtyname = %s".format(theyear, qty))
      }
    } catch {
      case e: Exception => e.printStackTrace
    }
    conn.close
  }
}