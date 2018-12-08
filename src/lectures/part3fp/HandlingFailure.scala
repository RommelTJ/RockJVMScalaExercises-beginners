package lectures.part3fp

import scala.util.{Failure, Success, Try}

object HandlingFailure extends App {

  // Create success and failure explicitly
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Fail!"))
  println(aSuccess)
  println(aFailure)

  // Most of the time, you don't have to create those explicitly, because the Try companion object's apply method
  // does it for you.
  def unsafeMethod(): String = throw new RuntimeException("Error!")
  val potentialFailure = Try(unsafeMethod()) // Try objects via the apply method.
  println(potentialFailure) // program doesn't crash!

  // Syntactic sugar
  val anotherPotentialFailure = Try {
    unsafeMethod()
  }
  println(anotherPotentialFailure)

  // Utilities
  println(potentialFailure.isSuccess) // false
  println(potentialFailure.isFailure)

}
