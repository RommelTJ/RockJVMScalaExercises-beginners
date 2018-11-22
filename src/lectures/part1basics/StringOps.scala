package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // Sample String Operations.
  println(str.charAt(2)) // Returns character at index 2, 'l'.
  println(str.substring(7, 11)) // Returns index 7 inclusive to 11 exclusive, 'I am'.
  println(str.split(" ").toList) // Splits by spaces.
  
}
