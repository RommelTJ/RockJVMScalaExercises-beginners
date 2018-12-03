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
  val adder = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }
  println(adder(3, 3))

}

trait MyFunction[A, B] {
  def apply(element: A): B
}
