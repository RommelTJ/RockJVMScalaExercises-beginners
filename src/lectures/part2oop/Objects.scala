package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person { // type and it's own instance.
    // "static"/"class"-level functionality.
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory Method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")

  }

  class Person(val name: String) {
    // instance-level functionality.
  }
  // COMPANIONS

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  val mary = Person
  val john = Person
  println(mary == john) // Pointing to the same instance.

  val michael = new Person("Michael")
  val jane = new Person("Jane")
  println(michael == jane) // Pointing to different instances.

  val bobbie = Person(michael, jane) // Using the apply method.

  // Scala Applications = Scala object with a main method.
  // def main(args: Array[String]): Unit

}
