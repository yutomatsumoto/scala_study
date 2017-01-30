package com.github.mazinai

/**
  * Created by mazinai_tarazu on 1/26/17.
  */
object Curry {

  def oldSum(x: Int, y:Int) = x + y

  def curriedSum(x: Int)(y: Int) = x + y

  def first(x: Int) = (y: Int) => x + y

  def curriedExe() = {
    val second =first(1)
    second(2)
  }

}
