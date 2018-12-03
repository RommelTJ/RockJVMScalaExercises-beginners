package lectures.part3fp

object AnonymousFunctions extends App {

  // Anonymous Function (Lambda)
  val doubler: Int => Int = x => x * 2 // Syntactic Sugar for Function1

  // Multiple parameters in a lambda.
  val adder = (a: Int, b: Int) => a + b
  val adder2: (Int, Int) => Int = (a, b) => a + b

  // No params
  val justDoSomething = () => 3
  val justDoSomething2: () => Int = () => 3
  println(justDoSomething) // prints lambda (lectures.part3fp.AnonymousFunctions$$$Lambda$9/914504136@2d6e8792)
  println(justDoSomething()) // prints 3

  // Curly Braces with Lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // More synctactic sugar.
  val niceIncrementer: Int => Int = (x: Int) => x + 1
  val niceIncrementer2: Int => Int = _ + 1 // equivalent to the above
  println(niceIncrementer2(1)) // prints 2

}
