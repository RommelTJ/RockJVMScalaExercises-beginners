package lectures.part2oop

object InheritanceAndTraits extends App {

  class Animal {
    def eat(): Unit = println("nom nom nom")
  }

  class Cat extends Animal

  val cat = new Cat
  cat.eat()

}
