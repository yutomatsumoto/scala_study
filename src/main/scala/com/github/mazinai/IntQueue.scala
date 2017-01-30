package com.github.mazinai

import scala.collection.mutable.ArrayBuffer

/**
  * Created by macky on 2017/01/30.
  *
  * trait test
  */

abstract class IntQueue {

  def get(): Int

  def put(x: Int)
}

class BasicIntQueue extends IntQueue {

  private val buf = new ArrayBuffer[Int]

  def get() = buf.remove(0)

  def put(x: Int) = buf += x
}

//今後実装するかもしれないメソッドを予約して上書き可能
trait Doubling extends IntQueue {

  abstract override def put(x: Int) = {
    println("aaa")
    //線形化したい
    super.put(x * 2)
  }
}

trait Incrementing extends IntQueue {

  abstract override def put(x: Int) = {
    println("bbb")
    super.put(x + 1)
  }
}

//Doublingが一番上にある
class MyQueue extends BasicIntQueue with Doubling

//先ずはMyQueue2のput、次は一番右のトレイトが実行される
class MyQueue2 extends BasicIntQueue with Doubling with Incrementing {

  override def put(x: Int) = {
    println("ccc")
    super.put(x + 2)
  }
}

