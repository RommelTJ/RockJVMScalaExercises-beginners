package lectures.part2oop

object AnonymousClasses extends App {

  trait Animal {
    def eat(): Unit
  }

  // Creating an Anonymous Class.
  val funnyAnimal: Animal = () => println("hahahaha")
  println(funnyAnimal.getClass)
  println(funnyAnimal.eat())

  class Person(name: String) {
    def sayHi(): Unit = println(s"Hi, my name is $name, how can I help?")
  }

}
