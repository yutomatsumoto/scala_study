package com.github.mazinai

/**
  * Created by macky on 2017/02/09.
  */
object LazyDemo {
  lazy val x = { println("init x"); "done"}
}
