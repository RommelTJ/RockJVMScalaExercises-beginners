package lectures.part2oop

object OOBasics extends App {

  // Instantiating a class in Scala
  val person = new Person("Rommel", 30)
  println(person.age)
  println(person.x)
  person.greet("Mike")
  person.greet()

}

// Class with constructor
// Class parameters are not fields in Scala. Add "val" or "var" to make them also fields.
class Person(name: String, val age: Int) {
  // Body
  val x = 2
  println(1 + 3)

  // Implied parameter.
  def greet(): Unit = println(s"Hi, I am $name")

  // Overloaded method.
  // Adding a method. Note that "this.name" is not a field, but a parameter.
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

}
