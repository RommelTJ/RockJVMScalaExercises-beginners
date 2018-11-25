package lectures.part2oop

object InheritanceAndTraits extends App {

  // Single-Class Inheritance.
  class Animal {
    // Access-Modifiers: public (default), private (class only), protected (class and subclass only).
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

  // Constructors
  class Person(name: String, age: Int)
  

}
