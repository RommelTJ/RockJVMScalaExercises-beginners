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

}
