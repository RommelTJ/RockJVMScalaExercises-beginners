package lectures.part4pm

object PatternsEverywhere extends App {

  // Big Idea #1
  try {
    // Some code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "NPE"
    case _ => "Something else"
  }
  // Catches are actually matches!

  // Big Idea #2
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // !?
  } yield 10 * x
  // Generators are also based on pattern matching!

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  println(filterTuples) // prints List(2, 12)
  // Case Classes, :: operators, ... also work.

  // Big Idea #3
  val aTuple = (1, 2, 3)
  val (a, b, c) = aTuple
  println(b) // prints 2
  // Multiple value definition based on pattern matching!

  val head :: tail = list
  println(head) // prints 1
  println(tail) // prints List(2, 3, 4)
  // Also works based on pattern matching.

  // Big Idea #4 - Partial Function
  val mappedList = list.map {
    case v if v % 2 == 0 => s"$v is even"
    case 1 => "The One"
    case _ => "Something else"
  } // Partial Function Literal

  // The above is equivalent to this:
  val mappedList2 = list.map { x => x match {
      case v if v % 2 == 0 => s"$v is even"
      case 1 => "The One"
      case _ => "Something else"
    }
  }

}
