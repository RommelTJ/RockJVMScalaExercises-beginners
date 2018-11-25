package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract classes
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

}
