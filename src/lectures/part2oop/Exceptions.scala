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
  // throw new OutOfMemoryError()
  // val array = Array.ofDim(Int.MaxValue)

  // Ex 2. Crashing with StackOverflowError.
  // throw new StackOverflowError()
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  // Ex 3. PocketCalculator

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")

  case object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }
    def subtract(x: Int, y: Int): Int = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def multiply(x: Int, y: Int): Int = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }
    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      x / y
    }
  }

  // println(PocketCalculator.add(Int.MaxValue, 10))
  // println(PocketCalculator.subtract(-1, Int.MaxValue))
  // println(PocketCalculator.divide(3, 0))
  println(PocketCalculator.divide(3, 2))

}
