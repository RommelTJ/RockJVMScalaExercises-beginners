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

  // Chained Methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  // Design Unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A new result")
  val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterChainedResult)

  // Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // unsafe, do not use this.

}
