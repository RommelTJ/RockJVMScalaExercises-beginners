package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false
  }

  println(Person.N_EYES)
  println(Person.canFly)

}
