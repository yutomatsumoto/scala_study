package com.github.mazinai

/**
  * Created by macky on 2017/02/09.
  *
  * 抽象valを使うtrait
  */
trait RationalTrait {

  val numerArg: Int
  val denomArg: Int

  require(denomArg != 0)

  private val g = gcd(numerArg, denomArg)

  val numer = numerArg / g
  val denom = denomArg / g

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  override def toString: String = numer + "/" + denom
}
