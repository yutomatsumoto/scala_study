package mazinai

object main {

  def main(args: Array[String]): Unit = {
    val exam = new exam

    //fizzbuzz
    exam.fizzBuzz(15).foreach(println(_))

    //primecheck
    println(exam.primeCheck(6689))
  }
}
