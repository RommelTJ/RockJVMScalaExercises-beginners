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
  // Range example.
  (1 to 10).foreach(x => print("Hello"))

  // List - A LinearSeq immutable linked list
  // - head, tail, isEmpty are fast O(1)
  // - most operations are O(n)
  // - Sealed - has two subtypes: object Nil (empty) and class ::
  val aList = List(1, 2, 3)
  val prepended = 42 :: aList // prepending operator
  println(prepended) // prints List(42, 1, 2, 3)
  val prependedAndAppended = 42 +: aList :+ 89 // +: = prepending, :+ = appending
  println(prependedAndAppended) // prints List(42, 1, 2, 3, 89)
  val fiveApples = List.fill(5)("apples")
  println(fiveApples) // prints List(apples, apples, apples, apples, apples)
  println(aList.mkString("-|-")) // prints 1-|-2-|-3

}
