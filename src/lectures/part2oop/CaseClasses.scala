package lectures.part2oop

object CaseClasses extends App {

  /*
  equals, hashCode, toString.
   */
  case class Person(name: String, age: Int)

  // 1 - Class parameters are promoted to fields.
  val jim = new Person("Jim", 34)
  println(jim.name)

}
