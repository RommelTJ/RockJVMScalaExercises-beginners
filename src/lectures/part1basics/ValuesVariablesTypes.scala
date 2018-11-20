package lectures.part1basics

object ValuesVariablesTypes extends App {

  // Syntax for declaring a val. Vals are immutable.
  // Types of vals are inferred, so you don't have to type 42.
  val x = 42
  println(x)

  // Strings. Semicolons are optional.
  val aString: String = "Hello"

  // Booleans.
  val aBoolean: Boolean = false

  // Characters.
  val aChar: Char = 'a'

  // Ints.
  val anInt: Int = 23 // 4 Bytes

  // Shorts and Longs
  val aShort: Short = 4613 // 2 Bytes
  val aLong: Long = 34636 // 8 Bytes

  // Floats
  val aFloat: Float = 2.0f
  // Doubles
  val aDouble: Double = 3.14

}
