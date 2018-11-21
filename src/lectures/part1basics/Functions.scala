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

  // Do this instead of loops. Use recursion instead of loops.
  // You need to specify return types of functions in recursive functions. You can also use Unit.
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))

  // Using Unit as the return type.
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

}
