package lectures.part3fp

object TuplesAndMaps extends App {

  // Tuples - finite ordered "lists"
  val aTuple = Tuple2(2, "hello, Scala") // Tuple2[Int, String] = (Int, String)
  // Can group at most 22 types.
  println(aTuple._1) // 2
  println(aTuple._2) // "hello, Scala"
  println(aTuple.copy(_2 = "goodbye Java")) // prints (2,goodbye Java)
  println(aTuple.swap) // prints (hello, Scala,2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()
  val aPhoneBook = Map(("Jim", 555), "Daniel" -> 789) // -> is a syntactic sugar for a tuple
  // a -> b is sugar for (a, b)\
  println(aPhoneBook) // prints Map(Jim -> 555, Daniel -> 789)

}
