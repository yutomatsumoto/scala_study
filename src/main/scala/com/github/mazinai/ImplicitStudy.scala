package com.github.mazinai

import java.awt.event.{ActionEvent, ActionListener}
import javax.swing.JButton

/**
  * Created by macky on 2017/02/10.
  */
class ImplicitStudy {
  val button = new JButton

  //通常の呼び出し
  //  button.addActionListener(
  //    new ActionListener {
  //      override def actionPerformed(e: ActionEvent) = println("foooo")
  //    }
  //  )

  //暗黙的な型変換
  implicit def function2ActionListener(f: ActionEvent => Unit):ActionListener= {
    new ActionListener {
      override def actionPerformed(e: ActionEvent) = f(e)
    }
  }

  //本来ならActionListener型が必要だが暗黙的に変換してる
  def addButton = {
    button.addActionListener(
      (_: ActionEvent) => println("fooo2")
    )
  }
}
