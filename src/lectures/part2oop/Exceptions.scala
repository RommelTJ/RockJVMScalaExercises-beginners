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

  val potentialFail = try {
    getInt(true) // Int
  } catch {
    case npe: NullPointerException => println("Caught a NullPointerException") // Unit
    case rte: RuntimeException => println("Caught a RuntimeException") // Unit
  } finally {
    // Code that will get executed no matter what.
    // Optional. Does not influence the return type of this expression.
    // Use finally only for side-effects.
    println("finally")
  }

  // Int and Unit means the compiler will infer an AnyVal
  // Int and Int means the compiler will infer an Int

  // 3 - Defining your own Exceptions.

  class MyException extends Exception
  val exception = new MyException
  // throw exception

  // Ex 1. Crashing with OutOfMemoryError.
  throw new OutOfMemoryError()

}
