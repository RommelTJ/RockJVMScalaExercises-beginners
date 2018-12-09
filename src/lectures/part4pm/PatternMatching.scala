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

}
