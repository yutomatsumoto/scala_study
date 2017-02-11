package com.github.mazinai

/**
  * Created by macky on 2017/01/31.
  */
class ListManager {

  def append[T](xs: List[T], ys: List[T]): List[T] = {
    xs match {
      case List() => ys
      case x :: xs1 => println(xs1); x :: append(xs1, ys)
    }
  }

  //foldLeftを記号でかける（スラッシュが左に傾いてるからLeft)
  def fLeft(xs: List[Int]): Int = (1 /: xs) (_ * _)

  //スラッシュが右に傾いてるからRight
  def fRight(xs: List[Int]): Int = (xs :\ 1) (_ * _)

  //foldLeftでリストを逆にして返す。例:List(1,2,3) -> 3::2::1::Nil
  def reverseLeft[T](xs: List[T]) = (List[T]() /: xs) { (ys, y) => y :: ys }
}
