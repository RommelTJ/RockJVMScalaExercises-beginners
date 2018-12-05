package lectures.part3fp

import scala.util.Random

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

  // Arrays - The equivalent of Java arrays. Can be constructed with predefined lengths.
  // Can be mutated.
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](3)
  println(threeElements) // prints [I@3cda1055
  threeElements.foreach(println) // prints 0 0 0
  // Mutation in place
  numbers(2) = 0 // syntactic sugar for numbers.update(2, 0) update is a special method in Scala.
  println(numbers.mkString(" ")) // prints 1 2 0 4

  // Arrays and Sequences
  val numbersSeq: Seq[Int] = numbers // this is ok because of implicit conversion!
  println(numbersSeq) // prints WrappedArray(1, 2, 0, 4)

  // Vectors
  // Default Implementation for immutable sequences
  // - Effectively constant indexed read and write
  // - Fast append/prepend
  // - Implemented as a fixed-branched tried (branch factor 32)
  // - Good performance for large sizes
  val vector: Vector[Int] = Vector(1, 2, 3)
  println(vector) // prints Vector(1, 2, 3)

  // Vectors vs Lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      var currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    // Average time it takes for this collection to be updated at a random index for a random value.
    times.sum * 1.0 / maxRuns
  }

}
