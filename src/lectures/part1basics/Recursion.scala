package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  }
  println(factorial(10))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x-1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression.
    }
    factorialHelper(n, 1)
  }
  println(anotherFactorial(5000)) // This avoids the StackOverflowError
  /*
  anotherFactorial(10) = factorialHelper(10, 1)
  = factorialHelper(9, 10 * 1)
  = factorialHelper(8, 9 * 10 * 1)
  = factorialHelper(7, 8 * 9 * 10 * 1)
  = ...
  = factorialHelper(2, 3 * 4 * ... * 8 * 9 * 10 * 1)
  = factorialHelper(1, 1 * 2 * 3 * 4 * ... * 8 * 9 * 10)
  = 1 * 2 * 3 * 4 * ... * 8 * 9 * 10
   */

  // When you need loops, use TAIL RECURSION.

  // Exercises.
  // 1. Concatenate a string n times.
  def stringConcat(aString: String, n: Int): String = {
    @tailrec
    def stringConcatHelper(x: Int, accumulator: String): String = {
      if (x <= 1) accumulator
      else stringConcatHelper(x-1, accumulator + "" + aString)
    }
    stringConcatHelper(n, aString)
  }
  println(stringConcat("hello,", 5))

  @tailrec
  def concatentatTailRec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatentatTailRec(aString, n-1, aString + accumulator)
  }
  println(concatentatTailRec("hello,", 5, ""))

  // 2. IsPrime function tail recursive.
  // 3. Fibonacci function, tail recursive.

}
