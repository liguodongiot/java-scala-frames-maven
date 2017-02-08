package com.lgd.frames.spark

import junit.framework.TestCase
import org.scalatest.{BeforeAndAfter, FunSuite}

/**
  * Created by liguodong on 2016/11/4.
  */
class HelloTests extends FunSuite with BeforeAndAfter {

  test("test sayHi") {

    val hi = new Hello().sayHi("liguodong")
    assert(hi.equalsIgnoreCase("hello,liguodong."))

  }


}
