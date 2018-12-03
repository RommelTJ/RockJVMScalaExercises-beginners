package lectures.part3fp

object AnonymousFunctions extends App {

  // Anonymous Function (Lambda)
  val doubler: Int => Int = x => x * 2 // Syntactic Sugar for Function1

  // Multiple parameters in a lambda.
  val adder = (a: Int, b: Int) => a + b
  val adder2: (Int, Int) => Int = (a, b) => a + b

}
