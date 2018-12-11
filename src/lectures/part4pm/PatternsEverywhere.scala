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

}
