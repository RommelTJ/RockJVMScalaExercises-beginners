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

  // 4 - Tuples
  val aTuple = (1, 2)
  val matchTuple = aTuple match {
    case (1, 1) => "tuple"
    case (something, 2) => s"$something can be extracted"
  }

  // 5 - Nested Tuples
  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => s"Found $v" // nested extracted value.
  }

}
