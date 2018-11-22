package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  // The '=>' parameter tells the compiler that the parameter will be called by name.
  def calledByName(x: => Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

}
