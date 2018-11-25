package lectures.part2oop

object InheritanceAndTraits extends App {

  // Single-Class Inheritance.
  class Animal {
    protected def eat(): Unit = println("nom nom nom")
  }

  class Cat extends Animal {
    def crunch(): Unit = {
      eat()
      println("crunch crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch()

}
