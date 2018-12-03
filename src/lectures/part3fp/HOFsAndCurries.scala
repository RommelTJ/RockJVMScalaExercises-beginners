package lectures.part3fp

object HOFsAndCurries extends App {
  // A function that takes a function as a parameter and returns a function as a result.
  val superiorFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null

  // Higher-Order Function (HOF)
  // Ex: map, flatMap, filter in MyList

  // Function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) => f(f(f(x)))
  // nTimes(f, n, x) => nTimes(f, n-1, f(x))
  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1)) // prints 11

}
