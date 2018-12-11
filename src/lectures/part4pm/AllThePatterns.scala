package lectures.part4pm

object AllThePatterns extends App {

  // 1 - Constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a numbers"
    case "scala" => "the scala"
    case true => "The Truth"
    case AllThePatterns => "A singleton Object"
  }

  // 2 - Match Anything (wildcard)
  val matchAnything = x match {
    case _ => ""
  }

}
