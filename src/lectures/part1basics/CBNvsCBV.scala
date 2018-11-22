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

}
