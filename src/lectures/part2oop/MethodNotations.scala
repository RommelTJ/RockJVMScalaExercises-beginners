package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) // prints true
  // Infix notation or Operator Notation. Only works with methods with only one parameter.
  println(mary likes "Inception") // Also prints true!

}
