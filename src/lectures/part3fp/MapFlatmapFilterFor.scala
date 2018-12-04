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

}
