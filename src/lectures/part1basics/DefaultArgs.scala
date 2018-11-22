package lectures.part1basics

object DefaultArgs extends App {

  // Using a default value.
  def tailRecFactorial(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else tailRecFactorial(n - 1, n * acc)

  val fact10 = tailRecFactorial(10, 1)
  println(fact10)
  val fact11 = tailRecFactorial(11)
  println(fact11)

}
