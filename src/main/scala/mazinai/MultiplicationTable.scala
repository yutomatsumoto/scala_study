package mazinai

/**
  * Created by macky on 2017/01/25.
  */
class MultiplicationTable {

  def makeRow(row: Int) = (1 to 10).map(e => " " * (4 - (e * row).toString.length) + e * row).mkString

  def multiTable = (1 to 10).map(makeRow(_)).mkString("\n")
}
