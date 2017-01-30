package com.github.mazinai

/**
  * Created by mazinai_tarazu on 1/30/17.
  */
class CaseClassSample {

  def exe() = {
    //caseクラスにするとコンパイラが自動でファクトリーメソッドを用意してくれる
    val v = Var("x")
    val op = BinOp("+", Number(1), v)

    //caseクラスは自動でクラスパラメータにvalをつける(フィールド化）
    //caseクラスはtoString等の実装をいい感じに追加してくれる
    println(v.name)

    //==とかで比較してもちゃんと比較できるようになる
    if (op.right == v) println("true") else println("false")

    //自動でクラスにcopyメソッドを追加する
    val opCopy = op.copy(operator = "-")
  }

  //caseクラスのおかげでパターンマッチができる
  //アノテーションをつけると全パターンあるかチェックしない
  def simplifyTop(expr: Expr): Expr = (expr: @unchecked) match {
    case UnOp("-", UnOp("-", e)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case _ => expr
  }

  def seqPattern(expr: List[Int]) = expr match {
    case List(0, _, _) => expr
    case List(0, _*) => expr
    case _ => expr
  }

  def taplePattern(expr: Any) = expr match {
    case (_, _) => expr
    case _ => expr
  }

  def classPattern(expr: String) = expr match {
    case s: String => s.length
    case _ => expr
  }

  //caseの中で同じ変数名を使用することはできないため、パターンガードを使う
  def simplifyAdd(e: Expr) = e match {
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _ => e
  }
}

//sealedをつけるとこのファイル以外から拡張できなくなる。
//そのためサブクラスのパターンがこれしかないというのを保証できる
sealed abstract class Expr

case class Var(name: String) extends Expr

case class Number(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr
