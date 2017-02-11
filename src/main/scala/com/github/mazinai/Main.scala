package com.github.mazinai

import com.github.mazinai2.{Exam => Test}

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

    //    val multiTable = new MultiplicationTable()
    //    print(multiTable.multiTable())

    //    val cont = Array("aaa", "bbb")
    //    val cont2 = Array("aaa", "bbb", "ccc")
    //    val e1 = Element.elem(cont)
    //    val e2 = Element.elem(cont2)
    //
    //    println(e1 above e2)

    //    val myQue = new MyQueue2
    //    myQue.put(1)
    //    println(myQue.get())

    //    val test = new Test
    //    test.print

    //    val text: Text = new Text("aaa")
    //    val anchor: Anchor = new Anchor("bbb")
    //    val style: Style = new Style("ccc")
    //    val html: Html = CreateHTML.title(text, anchor, style)
    //
    //    println(html.value)
    //
    //    val aaa = new TypeParam[Int, String](1, "aaa")

    val lm = new ListManager
    //    println(lm.append(List(1, 2, 3), List(4, 5, 6)))
    println(lm.product(List(1, 2, 3)))
  }
}