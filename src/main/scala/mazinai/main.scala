package mazinai

object Main {

  def main(args: Array[String]): Unit = {

    //fizzbuzz
    Exam.fizzBuzz(15).foreach(println(_))

    //primecheck
    println(Exam.primeCheck(6689))
  }
}
