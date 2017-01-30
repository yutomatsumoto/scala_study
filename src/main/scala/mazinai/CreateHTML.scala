package mazinai

/**
  * Created by mazinai_tarazu on 1/28/17.
  */
object CreateHTML {

  def title(text: Text, anchor: Anchor, style: Style): Html = {
    new Html(s"""<a src="${anchor.value}" style="${style.value}">${text.value}</a>""")
  }
}

class Anchor(val value: String) extends AnyVal
class Style(val value: String) extends AnyVal
class Text(val value: String) extends AnyVal
class Html(val value: String) extends AnyVal
