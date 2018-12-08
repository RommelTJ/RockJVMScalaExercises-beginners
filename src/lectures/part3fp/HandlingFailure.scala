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

  // orElse
  def backupMethod(): String = "Valid!"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry) // Success(Valid!)

  // if you're designing the API, wrap in a try
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException("BOOM"))
  def betterBackupMethod(): Try[String] = Success("Yay!")
  val betterFallbackTry = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterFallbackTry) // prints Success(Yay!)

  // Map, flatMap, and Filter
  println(aSuccess.map(_ * 2)) // 6
  println(aSuccess.flatMap(x => Success(x * 10))) // Success(30)
  println(aSuccess.filter(_ > 10)) // Failure(java.util.NoSuchElementException: Predicate does not hold for 3)

}
