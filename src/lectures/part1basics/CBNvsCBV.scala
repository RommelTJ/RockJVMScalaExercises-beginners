package lectures.part1basics

object CBNvsCBV extends App {

  def calledByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

}
