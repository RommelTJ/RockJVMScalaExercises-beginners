package lectures.part3fp

object WorkingWithOptions extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  // Options were invented to deal with unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod()) // WRONG, Some should always have a valid value inside.
  val correct = Option(unsafeMethod()) // Generate Some or None.
  println(correct) // Prints None

}
