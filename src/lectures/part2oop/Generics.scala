package lectures.part2oop

object Generics extends App {

  // Generic Type
  class MyList[+A] {
    // Use the Type A in class definition.
    def add[B >: A](element: B): MyList[B] = ???
    // A == Cat
    // B == Dog == Animal
    // If we get a Dog in a List of Cats, we return a List of Animals.
  }

  // Class with multiple Generic Type parameters.
  class MyMap[Key, Value]

  // Using a generic type.
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic Methods
  // Objects cannot be type-parameterized
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // Variance Problem.
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Covariance = List[Cat] extends List[Animal]
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? HARD QUESTION => We return a list of Animals

  // Invariance = List[Cat] and List[Animal] are two separate things.
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // Contravariance = Opposite of Covariance. A more specific type receives a more generic type.
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded Types
  class Cage[A <: Animal](animal: A) // Type A only accepts subtypes of type Animal.
  val cage = new Cage(new Dog)

  class Cage2[A >: Animal](animal: A) // Type A only accepts supertypes of type Animal.

  // This won't work because of the bounded type.
//  class Car
//  val newCage = new Cage(new Car)

  // Exercise: Expand MyList to be Generic.

}
