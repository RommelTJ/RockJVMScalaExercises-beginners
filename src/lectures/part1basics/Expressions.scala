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

}
