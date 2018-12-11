package lectures.part4pm

import exercises.{Cons, Empty, MyList}

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

  // 6 - Case Classes (Constructor Pattern)
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty => "Do something with empty"
    case Cons(h, t) => s"Do something with head: $h, and tail: $t"
    case Cons(h, Cons(subhead, t)) => "Case classes can also be nested and extracted"
  }

  // 7 - List Patterns
  val aStandardList = List(1, 2, 3, 42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "An extractor for a List" // Advanced
    case List(1, _*) => "A vararg pattern (list of arbitrary length)." // Advanced
    case 1 :: List(_) => "An infix pattern"
    case List(1, 2, 3) :+ 42 => "An infix pattern"
  }

  // 8 - Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => "This is a list" // explicit type specifier
    case _ => "Any"
  }

  // 9 - Name Binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => "Name Binding, so you can use the name later."
    case Cons(1, rest @ Cons(2, _)) => "You can also use name binding with nested patterns."
  }

}
