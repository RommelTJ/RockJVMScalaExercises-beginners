package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length) - NullPointerException

  // throwing and catching exceptions.

  // 1 - Throwing.
  // val aWeirdValue: String = throw new NullPointerException // Nothing.

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes.

  // 2 - Catching.

  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("No Int for you!")
    else 42
  }

  try {
    getInt(true)
  } catch {
    case rte: RuntimeException => println("Caught a RuntimeException")
  } finally {
    // Code that will get executed no matter what.
    println("finally")
  }

}
