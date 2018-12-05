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

  // Ranges
  val aRange: Seq[Int] = 1 to 10
  val aRange2 = 1 until 10
  aRange.foreach(println) // Inclusive, i.e. prints 1 - 10
  aRange2.foreach(println) // Not Inclusive, i.e. prints 1 - 9

}
