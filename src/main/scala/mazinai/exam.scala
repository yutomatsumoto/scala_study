package mazinai

/**
  * Created by macky on 2016/12/01.
  */
object Exam {

  def fizzBuzz(n: Int): List[String] = {
    (1 to n).toList.map { v: Int =>
      if (v % 15 == 0) "FizzBuzz" else if (v % 3 == 0) "Fizz" else if (v % 5 == 0) "Buzz" else v.toString()
    }
  }

  def primeCheck(n: Int): String = "これは素数" + (if ((2 until n).exists(n % _ == 0) && n > 1) "ではない" else "")

  def cal(year: Int, month: Int) = {
    val monthLimit = month match {
      case 4 | 6 | 9 | 11 => 30
      case 2 => if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 29 else 28
      case _ => 31
    }

    val dayOfWeek = {
      val times = month match {
        case 1 | 2 => (year - 1, month + 12)
        case _ => (year, month)
      }
      (times._1 + times._1 / 4 - times._1 / 100 + times._1 / 400 + (13 * times._2 + 8) / 5 + 1) % 7
    }

    println("SU MO TU WE TH FR SA")

    (1 to monthLimit+ dayOfWeek).map { i =>
      (i, if (i < dayOfWeek) 0 else i - dayOfWeek)
    }.foreach { case(index, day) =>
      val printDay = {
        (if (day == 0) "  " else if (day > 9) day else " " + day) + " " +
        (if (index % 7 == 0) "\n" else "")
      }
      print(printDay)
    }
  }

}
