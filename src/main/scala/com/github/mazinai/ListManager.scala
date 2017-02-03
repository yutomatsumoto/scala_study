package com.github.mazinai

/**
  * Created by macky on 2017/01/31.
  */
class ListManager {

  def append[T](xs: List[T], ys: List[T]): List[T] = {
    xs match {
      case List() => ys
      case x :: xs1 => println(xs1);x :: append(xs1, ys)
    }
  }
}
