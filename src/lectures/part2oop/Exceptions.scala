package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length) - NullPointerException

  // throwing and catching exceptions.

  val aWeirdValue: String = throw new NullPointerException // Nothing.

  // throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes.

}
