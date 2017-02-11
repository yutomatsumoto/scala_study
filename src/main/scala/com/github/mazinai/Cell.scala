package com.github.mazinai

/**
  * Created by mazinai_tarazu on 2/7/17.
  */

//非変(完全に一致してる型しか扱えない
//javaの配列は共変なので、StringにIntを格納してもコンパイルが通る（その後例外で止まる）
class Cell[T](init: T) {

  private[this] var current = init

  def get = current

  def set(x: T) = {
    current = x
  }
}

//下限境界が設定されてる
//例としてフルーツ型を継承したりんご型とオレンジ型があるとして、
//Queue[オレンジ]にりんご型を入れることができて、結果はQueue[フルーツ]となる
class Queue[+T](private val leading: List[T], private val trailing: List[T]) {

  def enqueue[U >: T](x: U) = new Queue[U](leading, x :: trailing)
}
