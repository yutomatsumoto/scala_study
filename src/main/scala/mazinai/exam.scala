package mazinai

/**
  * Created by macky on 2016/12/01.
  */
class exam() {

  def fizzBuzz(n: Int): List[String] = {
    (1 to n).toList.map { v: Int =>
      if (v % 15 == 0) "FizzBuzz" else if (v % 3 == 0) "Fizz" else if (v % 5 == 0) "Buzz" else v.toString()
    }
  }

  def primeCheck(n: Int): String = {
    if ((2 until n).filter(n % _ == 0).isEmpty && n > 1) "これは素数" else "これは素数ではない"
  }
}
