package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract classes - cannot be instantiated.
  abstract class Animal {
    val creatureType: String = "wild"
    def eat(): Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat(): Unit = println("crunch crunch crunch")
  }

  // Traits
  trait Carnivore {
    val preferredMeal: String = "fresh meat"
    def eat(animal: Animal): Unit
  }
  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "Lizard"
    override def eat(): Unit = println("chomp chomp chomp")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}.")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // Traits vs Abstract Classes
  // 1 - Traits do not have constructor parameters.
  // 2 - You can only extend one class, but can inherit multiple traits.
  // 3 - Traits are behavior (what something does), but Abstract Class is a type of "thing".

  // Scala's Type Hierarchy
  // scala.Any <- scala.AnyRef (java.lang.Object) <- scala.Null
  // scala.Any <- scala.AnyVal (primitives) <- scala.Nothing

}
