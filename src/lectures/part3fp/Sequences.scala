package lectures.part3fp

object Sequences extends App {

  // Sequences - A very general interface for data structures that
  // - have a well defined order
  // - can be indexed
  // - Support: apply, iterator, length, reverse, concatenation, appending, preprending, grouping, etc.
  val aSequence = Seq(1, 2, 3, 4)
  println(aSequence) // prints List(1, 2, 3, 4)
  println(aSequence.reverse)
  println(aSequence(2)) // prints 3
  println(aSequence ++ Seq(7, 6, 5)) // Concatenating Sequences
  val newSequence = aSequence ++ Seq(7, 6, 5)
  println(newSequence.sorted)

}
