package com.lgd.frames.spark

/**
  * Created by liguodong on 2016/11/4.
  */

import org.scalatest.{BeforeAndAfter, FunSuite}



class DemoTests extends FunSuite with BeforeAndAfter {

  test("test sayHi") {

    val hi = new Demo().sayHi("FOO")
    assert(hi == "FOO")
  }

}
