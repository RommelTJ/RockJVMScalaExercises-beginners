package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}."
    def +(person: Person): String = s"${person.name} is hanging out with ${this.name}."
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) // prints true
  // Infix notation or Operator Notation. Only works with methods with only one parameter.
  println(mary likes "Inception") // Also prints true!

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom) // Scala is very permissive with method naming!

}
