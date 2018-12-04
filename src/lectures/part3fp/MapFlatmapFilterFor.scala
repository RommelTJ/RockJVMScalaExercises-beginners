package lectures.part3fp

object MapFlatmapFilterFor extends App {

  // Scala List.
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // Map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // Filter
  println(list.filter(_ % 2 == 0))

  // Flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println(list)
  println(toPair)
  println(list.flatMap(toPair))

  // Print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val characters = List('a', 'b', 'c', 'd')
  val colors = List("Black", "White")
  // "Iterating" in Scala.
  val combinations = numbers.flatMap(n => characters.flatMap(c => colors.map(color => s"$c$n$color")))
  println(combinations)

  // Foreach
  list.foreach(println)

}
