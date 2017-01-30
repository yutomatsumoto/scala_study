package com.github.mazinai

/**
  * Created by mazinai_tarazu on 1/26/17.
  */
object FileMatch {

  private val lists = List("aaa", "bbb", "ccc")

//  def filesMatching(query: String,
//                    matcher: (String, String) => Boolean) = {
//    for (list <- lists; if matcher(list, query))
//      yield list
//  }

  def filesMatching(matcher: String => Boolean) = {
    for (list <- lists; if matcher(list))
      yield list
  }
//  def listRegex(query: String) = filesMatching(query, _.matches(_))
//  def listRegex(query: String) = filesMatching(query, (fileName: String, query: String) => fileName.matches(query))
  def listRegex(query: String) = filesMatching(_.matches(query))

}
