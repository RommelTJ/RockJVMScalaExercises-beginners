package lectures.part1basics

object DefaultArgs extends App {

  def tailRecFactorial(n: Int, acc: Int): Int =
    if (n <= 1) acc
    else tailRecFactorial(n - 1, n * acc)

  val fact10 = tailRecFactorial(10, 1)
  println(fact10)
}
