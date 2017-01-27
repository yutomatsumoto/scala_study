package mazinai

object Main {

  def main(args: Array[String]): Unit = {

    //fizzbuzz
//    Exam.fizzBuzz(927).foreach(println(_))

    //primecheck
//     println(Exam.primeCheck(824)

    //calendar
//    Exam.cal(2014, 5)

//    val gameValues = Map("fallout4"->7800, "undertale"->980)
//    print(Exam.mapTest(gameValues))

//    val rational = new Rational(1, 2)
//    val rational2 = new Rational(1, 3)
//    println(rational + rational2)

//    println(Exam.yieldTest(List("a", "bb", "ccc")))

    val multiTable = new MultiplicationTable()
    print(multiTable.multiTable())
  }
}