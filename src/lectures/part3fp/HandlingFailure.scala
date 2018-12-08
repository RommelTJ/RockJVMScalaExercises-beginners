package lectures.part3fp

import scala.util.{Failure, Success}

object HandlingFailure extends App {

  // Create success and failure explicitly
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Fail!"))
  println(aSuccess)
  println(aFailure)

}
