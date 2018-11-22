package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // Sample String Operations.
  println(str.charAt(2)) // Returns character at index 2, 'l'.
  println(str.substring(7, 11)) // Returns index 7 inclusive to 11 exclusive, 'I am'.
  println(str.split(" ").toList) // Splits by spaces.
  println(str.startsWith("Hello")) // Testing if it starts with "Hello".
  println(str.replace(" ", "-")) // Replacing spaces with dashes.
  println(str.toLowerCase) // Converting to Lower Case.
  println(str.length) // Getting the length of a string.

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(aNumber)
  println('a' +: aNumberString) // Prepending operator
  println(aNumberString :+ 'z') // Appending operator
  println(str.reverse) // Reversing a String.
  println(str.take(2)) // Get the first two characters, 'He'.

  // Scala-specific: String interpolators.

  // S-interpolators.
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old."
  val greeting2 = s"Hello, my name is $name and I will be turning ${age + 1}."
  println(greeting)
  println(greeting2)

  // F-interpolators. (uses printf format)
  val speed = 12.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute." // 2 characters total, minimum; 2 decimal precision.
  println(myth)

  // Raw-interpolator.
  println(raw"This is a \n newline") // Prints the backslash n
  val escaped = "This is a \n newline"
  println(raw"$escaped") // This still prints the backslash normally since it is injected.

}
