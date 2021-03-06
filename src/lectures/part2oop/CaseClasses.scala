package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString.
   */
  case class Person(name: String, age: Int)

  // 1 - Class parameters are promoted to fields.
  val jim = Person("Jim", 34)
  println(jim.name)

  // 2 - A sensible toString.
  println(jim.toString)
  println(jim)

  // 3 - Equals and HashCode are implemented.
  val jim2 = Person("Jim", 34)
  println(jim == jim2) // true, preferred way
  println(jim.equals(jim2)) // true

  // 4 - Case Classes have a handy copy method.
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5 - Case Classes have companion objects.
  val thePerson = Person
  println(thePerson)
  val mary = Person("Mary", 23) // Companion object's apply() does the same thing as the constructor, thus you don't need 'new'.
  println(mary)

  // 6 - Case Classes are serializable.
  // Akka - deals with sending serializable messages through the network.

  // 7 - Case Classes have extractor patterns = Can be used in PATTERN MATCHING.

  // You can also have case objects.
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

}
