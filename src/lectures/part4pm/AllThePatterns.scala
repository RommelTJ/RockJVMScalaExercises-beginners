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

  // 3 - Match Anything (variable)
  val matchAVariable = x match {
    case something => s"I've found $something" // extracted value
  }

}
