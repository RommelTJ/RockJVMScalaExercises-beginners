package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {

  // Switch on Steroids
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "Double or nothing"
    case 3 => "Third's time the charm"
    case _ => "Something else" // _ = WILDCARD
  }
  println(s"$x: $description")

  // 1 - It can decompose values.
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the U.S." // Guard statements
    case Person(n, a) => s"Hi, my name is $n and I'm $a years old."
    case _ => "I don't know who I am."
  }
  println(greeting)

  // Things to note about Pattern Matching in Scala:
  // Cases are matched in order.
  // If nothing matches, you get a scala.MatchError
  // The return type will be the unified type of all types in all the cases (i.e. if they're all Strings,
  //   it will be string, if it's a mix, it will be "Any").

}
