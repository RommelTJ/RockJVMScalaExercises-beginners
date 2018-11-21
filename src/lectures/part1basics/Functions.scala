package lectures.part1basics

object Functions extends App {

  // Scala Functions.
  def aFunction(a: String, b: Int): String = a + " " + b
  // This is a function with a code block, which is also an expression in Scala.
  def aFunction2(a: String, b: Int): String = {
    a + " " + b
  }

  // Calling a function.
  println(aFunction("Hello", 3))

  // Calling a function without parameters by just their names.
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

}
