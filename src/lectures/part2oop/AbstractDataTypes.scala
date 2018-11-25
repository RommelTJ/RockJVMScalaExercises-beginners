package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract classes - cannot be instantiated.
  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat(): Unit = println("crunch crunch crunch")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

}
