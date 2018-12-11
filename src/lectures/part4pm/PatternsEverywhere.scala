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

}
