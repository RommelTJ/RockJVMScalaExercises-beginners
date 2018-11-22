package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  // The '=>' parameter tells the compiler that the parameter will be called by name.
  def calledByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  calledByValue(System.nanoTime()) // This returns the same time twice.
  calledByName(System.nanoTime()) // This returns two different times.

  // Note on call by value vs call by name.
  // In By Value, the exact value is computed before the function evaluates.
  // In By Name, the expression is passed lirerally as-is and the expression is evaluated every time.

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)
  printFirst(34, infinite())
  // This works because => delays the evaluation of infinite(), and since y is never used, it's fine and prints 34.

}
