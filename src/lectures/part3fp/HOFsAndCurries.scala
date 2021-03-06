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

  // nTimesBetter(f, n) = x => f(f(f...(x)))
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }
  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1)) // prints 11

  // Curried Functions
  val superAdder: Int => Int => Int = (x: Int) => (y: Int) => x + y
  val add3 = superAdder(3) // y => 3 + y
  println(add3(10)) // prints 13
  println(superAdder(3)(10)) // prints 13

  // Functions with multiple parameter lists
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double => String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double => String) = curriedFormatter("%10.8f")
  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) =
    x => y => f(x, y)
  def fromCurry(f: (Int => Int => Int)): (Int, Int) => Int =
    (x, y) => f(x)(y)

  def compose[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))

  def andThen[A, B, C](f: A => B, g: B => C): A => C =
    x => g(f(x))

  def superAdder2: (Int => Int => Int) = toCurry(_ + _)
  def add4 = superAdder2(4)
  println(add4(17)) // prints 21

  val simpleAdder = fromCurry(superAdder2)
  println(simpleAdder(4, 17)) // prints 21

  val add2 = (x: Int) => x + 2
  val times3 = (x: Int) => x * 3
  val composed = compose(add2, times3)
  val ordered = andThen(add2, times3)
  println(composed(4)) // prints 14
  println(ordered(4)) // prints 18

}
