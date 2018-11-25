package lectures.part2oop

object Generics extends App {

  // Generic Type
  class MyList[A] {
    // Use the Type A in class definition.
  }

  // Class with multiple Generic Type parameters.
  class MyMap[Key, Value]

  // Using a generic type.
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

}
