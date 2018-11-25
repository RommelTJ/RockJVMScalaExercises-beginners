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

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Lizard"
    override def eat(): Unit = println("chomp chomp chomp")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}.")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

}
