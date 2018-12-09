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
  // Pattern Matching works really well with sealed classes.

  // 2 - Pattern Matching on Sealed hierarchies
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal
  val animal: Animal = Dog("Pug")
  animal match {
    case Dog(b) => println(s"Matched dog of breed: $b")
  }

  // Don't match everything. It can be more verbose.
  val isEven = x % 2 == 0
  val isEven2 = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  val isEvenCond = if (x%2 == 0) true else false
  val isEvenNorm = x % 2 == 0 // easier to read

  // Exercise
  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  // Simple function that uses Pattern matching
  // Takes an Expr => Human Readable form of it.
  // Ex: Sum(Number(2), Number(3)) => 2 + 3
  // Ex: Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
  // Ex: Prod(Sum(Number(2), Number(3)), Number(4)) => (2 + 3) * 4
  // Ex: Sum(Prod(Number(2), Number(1)), Number(3)) => 2 * 1 + 3

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => s"${show(e1)} + ${show(e2)}"
    case Prod(e1, e2) => {
      def maybeShowParen(exp: Expr): String = exp match {
        case Prod(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => s"(${show(exp)})"
      }

      s"${maybeShowParen(e1)} * ${maybeShowParen(e2)}"
    }
  }

}
