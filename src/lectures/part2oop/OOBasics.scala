package lectures.part2oop

object OOBasics extends App {

  // Instantiating a class in Scala
  val person = new Person("Rommel", 30)
  println(person)

}

// Class with constructor
class Person(name: String, age: Int)
