package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) // prints true

}
