package lectures.part3fp

object WhatsAFunction extends App {
  // Dream: Use a functions as first class elements.
  // Problem: We come from an OOP world.

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2)) // can be called like a function and calls the apply method

  // Function Types = Function1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }
  println(stringToIntConverter("2") + 3)

  // By Default, Scala supports function like the above up to 22 parameters
  // (Int, Int) => Int is syntactic sugar for Function2[Int, Int, Int].
  val adder: (Int, Int) => Int = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(adder(3, 3))

  // MAJOR TAKEAWAY: ALL SCALA FUNCTIONS ARE OBJECTS.

  // Exercises:
  // 1 - a function that takes 2 strings and concatenates them.
  // 2 - MyList implementation and transform MyPredicate and MyTransformer into function types.
  // 3 - Define a function which takes an Int argument and returns another function which takes an Int and return an Int.
  // 3.1 - What's the type of this function.
  // 3.2 - How to do it.

  val concat: (String, String) => String = new Function2[String, String, String] {
    def apply(s1: String, s2: String): String = s1 + s2
  }
  println(concat("Hello ", "World"))

  // Higher-Order Functions
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(v2: Int): Int = v1 + v2
    }
  }
  val adder3 = superAdder(3)
  println(adder3(4)) // 3 + 4 = 7
  println(superAdder(10)(20)) // 20 + 10 = 30 - A curried function.

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
