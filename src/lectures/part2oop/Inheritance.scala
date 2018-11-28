package lectures.part2oop

object Inheritance extends App {

  // Single-Class Inheritance.
  sealed class Animal {
    // Access-Modifiers: public (default), private (class only), protected (class and subclass only).
    val creatureType = "wild"
    def eat(): Unit = println("nom nom nom")
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
  class Person(name: String, age: Int) {
    // Auxiliary Constructor
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog(override val creatureType: String = "domestic") extends Animal {
    // override val creatureType: String = "domestic"
    override def eat(): Unit = {
      super.eat()
      println("woof crunch crunch")
    }
  }
  val dog = new Dog("K9")
  dog.eat()
  println(dog.creatureType)

  // Type Substitution (aka polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat() // Unknown Animal is of type Dog, calls eat() from Dog class

  // Overriding (supplying different implementation in derived classes)
  // vs Overloading (supplying different signatures for same methods in same class)

  // Super

  // Preventing Overrides
  // 1 - use final on member.
  // 2 - use final on class.
  // 3 - seal the class = extend classes in THIS FILE ONLY, but prevent extension in other files

}
