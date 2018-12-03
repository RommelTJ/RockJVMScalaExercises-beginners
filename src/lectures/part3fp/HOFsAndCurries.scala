package lectures.part3fp

object HOFsAndCurries extends App {
  // A function that takes a function as a parameter and returns a function as a result.
  val superiorFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = ???
}
