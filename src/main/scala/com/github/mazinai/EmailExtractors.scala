package com.github.mazinai

/**
  * Created by macky on 2017/02/13.
  *
  * Extractors(抽出子) sample
  *
  * unapplyを定義するとcaseで使用することができるようになる。
  * case classにした場合自動で定義されるため、caseで使用可能になる。
  * 挙動的には、caseにそのオブジェクトがあった場合、N.unapply(n)が実行され、
  * その結果がSomeだった場合変数に束縛される
  *
  */
object EmailExtractors {

  // 注入メソッド(オプション
  def apply(user: String, domain: String) = user + "@" + domain

  // 抽出メソッド(必須
  // applyでやりたいことの逆を実装する（名前的にもそういう意味DAYONE
  // 抽出メソッドがある場合は抽出子と呼ぶ
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}

object DomainExtractors {

  def apply(parts: String*): String = parts.reverse.mkString(".")

  //可変個のマッチ用メソッド
  def unapplySeq(whole: String): Option[Seq[String]] = {
    Some(whole.split("\\.").reverse)
  }

  def isTomInDotCom(s: String): Boolean = s match {
    case EmailExtractors("tom", DomainExtractors("com", _*)) => true
    case _ => false
  }
}
