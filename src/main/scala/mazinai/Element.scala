package mazinai


/**
  * Created by macky on 2017/01/27.
  */
object Element {

  private class ArrayElement(val contents: Array[String]) extends Element

  private class UniformElement(
                                ch: Char,
                                override val width: Int,
                                override val height: Int
                              ) extends Element {

    private val line = ch.toString * width

    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element = new UniformElement(chr, width, height)
}

abstract class Element {

  def contents: Array[String]

  def width: Int = if (height == 0) 0 else contents(0).length

  def height: Int = contents.length

  def above(that: Element) = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    Element.elem(this1.contents ++ that1.contents)
  }

  def beside(that: Element) = {
    //A("aaa","bbb") beside B("aaa", "b", "ccc")
    //A.heighten(3)
    val this1 = this heighten that.height
    //("aaa","bbb") beside ("aaa", "b")
    val that1 = that heighten this.height
    Element.elem(
      for (
        (line1, line2) <- this1.contents zip that1.contents
      ) yield line1 + line2
    )
  }

  def widen(w: Int): Element = {
    if (w <= width) this
    else {
      val left = Element.elem(' ', (w - width) / 2, height)
      val right = Element.elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  }

  // ex ("aaa", "bbb")
  def heighten(h: Int): Element = {
    // 3 <= 2
    if (h <= height) this
    else {
      // ' ', 3, (3 - 2)/ 2 = Element ()
      val top = Element.elem(' ', width, (h - height) / 2)
      // ' ', 3, 3 - 2 - 0 = Element Array("   ")
      val bot = Element.elem(' ', width, h - height - top.height)
      // ("aaa", "bbb", "   ")
      top above this above bot
    }
  }

  override def toString = contents mkString "\n"
}
