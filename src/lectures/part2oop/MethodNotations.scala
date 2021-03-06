package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}."
    def learns(topic: String): String = s"$name learns $topic."
    def learnsScala: String = this learns "Scala" // learns("Scala")
    def +(person: Person): String = s"${person.name} is hanging out with ${this.name}."
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def unary_! : String = s"$name, what the heck!?"
    def isAlive: Boolean = true
    def apply(): String = s"Hi! My name is $name and I like $favoriteMovie."
    def apply(n: Int): String = s"$name watched $favoriteMovie $n times."
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception")) // prints true
  // Infix notation or Operator Notation. Only works with methods with only one parameter.
  println(mary likes "Inception") // Also prints true!

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)
  println(mary + tom) // Scala is very permissive with method naming!

  // ALL OPERATORS ARE METHODS IN SCALA.
  println(1 + 2) // 3
  println(1.+(2)) // 3

  // Prefix Notation
  val x = -1 // Unary Operators are also methods! '+', '-', '!', '~'.
  val y = 1.unary_-
  println(!mary) // Syntactic sugar.
  println(mary.unary_!)

  // Postfix Notation. Only available to methods without parameters.
  println(mary.isAlive)
  println(mary isAlive) // Not used in practice since the dot notation is more clear.

  // Apply.
  println(mary.apply())
  println(mary()) // Equivalent to the above since compiler will delegate to the apply() method.

  // 1. Overload + operator and returns person + "the rockstar" => "Mary (the rockstar)".
  println((mary + "the rockstar")())

  // 2. Add age to person class with default 0 and add unary + operator => new Person with age + 1.
  println(mary.age)
  println((+mary).age)

  // 3. Add "learns" method in Person class that takes String => "Mary learns $leans". Then add learnsScala method
  // that calls learns method with "Scala". Use it in postfix notation.
  println(mary.learns("Boogers"))
  println(mary learnsScala)

  // 4. Overload apply method to receive a number and return String
  // mary.apply(2) => "Mary watched Inception 2 times."
  println(mary(2))

}
