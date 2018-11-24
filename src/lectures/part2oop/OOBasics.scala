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
class Person(name: String, val age: Int = 0) {
  // Body
  val x = 2
  println(1 + 3)

  // Overloading/Multiple constructors.
  def this(name: String) = this(name, 0) // Calls primary constructor with an auxiliary constructor.
  def this() = this("John Doe")

  // Implied parameter.
  def greet(): Unit = println(s"Hi, I am $name")

  // Overloaded method.
  // Adding a method. Note that "this.name" is not a field, but a parameter.
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

}

// Novel Class
class Novel(name: String, yearOfRelease: Int, author: Writer) {

  // Returns the age of author at yearOfRelease.
  def authorAge(): Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)

}

// Writer Class
class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName: String = s"$firstName $surname"
}

// Counter Class
class Counter(x: Int) {
  def getCurrentCount(): Int = x

  def increment(): Counter = new Counter(x+1)
  def increment(n: Int) = new Counter(x+n)

  def decrement(): Counter = new Counter(x-1)
  def decrement(n: Int) = new Counter(x-n)

}
