package mazinai

/**
  * Created by macky on 2017/01/24.
  */
class Rational(n: Int, d: Int) {

  require(d != 0)
  //最大公約数
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)

  override def toString: String = s"$numer / $denom"

  def +(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def lessThan(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if(lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
}
