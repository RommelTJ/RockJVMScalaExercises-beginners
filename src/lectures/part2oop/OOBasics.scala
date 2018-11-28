package lectures.part2oop

object OOBasics extends App {

  // Instantiating a class in Scala
  val person = new Person("Rommel", 30)
  println(person.age)
  println(person.x)
  person.greet("Mike")
  person.greet()

  // Testing exercises.
  val author = new Writer("Charles", "Dickens", 1812)
  val author2 = new Writer("Rommel", "Rico", 1988)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)
  println(author.yearOfBirth)
  println(author.fullName)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(author2))
  println(novel.isWrittenBy(impostor))
  val novel2 = novel.copy(2018)
  println(novel.authorAge)
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.print // 0
  counter.increment.print // 1
  counter.increment.print // 1
  counter.increment.increment.print // 2
  counter.increment(3).print // 3
  counter.decrement.print // -1
  counter.decrement(5).print // -5

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
  def authorAge: Int = yearOfRelease - author.yearOfBirth

  def isWrittenBy(author: Writer): Boolean = author == this.author

  def copy(newYearOfRelease: Int): Novel = new Novel(name, newYearOfRelease, author)

}

// Writer Class
class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
  def fullName: String = s"$firstName $surname"
}

// Counter Class
class Counter(val count: Int = 0) {
  // def getCurrentCount: Int = x // Or you could just make "x" parameter a val.

  def increment = new Counter(count + 1) // immutability - EXTREMELY IMPORTANT
  // def increment(n: Int) = new Counter(count + n)
  def increment(n: Int): Counter = {
    if (n <= 0) this
    else increment.increment(n - 1)
  }

  def decrement = new Counter(count - 1)
  // def decrement(n: Int) = new Counter(count - n)
  def decrement(n: Int): Counter = {
    if (n <= 0) this
    else decrement.decrement(n - 1)
  }

  def print = println(count)

}
