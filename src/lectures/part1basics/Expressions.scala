package lectures.part1basics

object Expressions extends App {

  // Expressions.
  val x = 1 + 2
  println(x)

  // Math expressions.
  println(2 + 3 * 4)
  // Math operators: +, -, *, /, &, |, ^, <<, >>, >>> (right shift with zero extension).

  // Equality
  println(1 == x)
  // Equality Operators: ==, !=, >, >=, <, <=

  // Boolean expressions.
  println(!(1 == x)) // true
  // Logical negation. !, &&, ||

  // Operations on variables.
  var aVariable = 2
  aVariable += 3 // also works with -=, *=, /=
  // Note: These are all side-effects.

  // Instructions (DO) vs Expressions (VALUE).
  // In Scala we think in terms of expressions.

  // If expression.
  val aCondition = true
  val aConditionedValue = if(aCondition) 5 else 3
  println(aConditionedValue) // prints 5
  println(if(aCondition) 5 else 3) // prints 5
  println((if(aCondition) 5 else 3) + 2) // prints 7

  // Loops are discouraged in Scala. Don't do this.
  var i = 0
  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  // Everything in Scala is an Expression.

  val aWeirdValue = (aVariable = 3) // Unit value, equivalent to void.
  println(aWeirdValue) // prints "()"

  // Side Effect examples: println(), whiles, and reassigning (vars).

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }
  // The value of the block is the value of its last expression.
  println(aCodeBlock)

  // 1. Difference between "Hello World" and println("Hello World")


  // 2. What is the value of the below code block?
  val someValue = {
    2 < 3
  }
  println(someValue) // true

  // 3. What is the value of the below code block?
  val someOtherBlock = {
    if (someValue) 239 else 986
    42
  }
  println(someOtherBlock)

}
