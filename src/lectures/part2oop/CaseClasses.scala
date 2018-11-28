package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString.
   */
  case class Person(name: String, age: Int)

  // 1 - Class parameters are promoted to fields.
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2 - A sensible toString.
  println(jim.toString)
  println(jim)

  // 3 - Equals and HashCode are implemented.
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true, preferred way
  println(jim.equals(jim2)) // true
  
}
