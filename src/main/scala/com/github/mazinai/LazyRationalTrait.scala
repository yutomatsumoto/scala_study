package com.github.mazinai

/**
  * Created by macky on 2017/02/09.
  */
trait LazyRationalTrait {

  val numerArg: Int
  val denomArg: Int

  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }

  lazy val numer = numerArg / g
  lazy val denom = denomArg / g

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  override def toString: String = numer + "/" + denom
}
