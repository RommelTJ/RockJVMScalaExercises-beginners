package lectures.part2oop

object OOBasics extends App {

  // Instantiating a class in Scala
  val person = new Person("Rommel", 30)
  println(person.age)

}

// Class with constructor
// Class parameters are not fields in Scala. Add "val" or "var" to make them also fields.
class Person(val name: String, val age: Int)
