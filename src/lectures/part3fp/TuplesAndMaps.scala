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
  val aPhoneBook = Map(("Jim", 555), "Daniel" -> 789).withDefaultValue(-1) // -> is a syntactic sugar for a tuple
  // a -> b is sugar for (a, b)\
  println(aPhoneBook) // prints Map(Jim -> 555, Daniel -> 789)

  // Map Operations
  println(aPhoneBook.contains("Jim")) // prints true
  println(aPhoneBook("Jim")) // prints 555
  // println(aPhoneBook("Mary")) // NoSuchElementException
  println(aPhoneBook("Mary")) // prints -1 because we added the withDefaultValue(-1)

  // Add a Pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = aPhoneBook + newPairing
  println(newPhoneBook) // prints Map(Jim -> 555, Daniel -> 789, Mary -> 678)

  // Functionals on Maps
  // map, flatMap, filter
  println(aPhoneBook.map(pair => pair._1.toLowerCase -> pair._2)) // prints Map(jim -> 555, daniel -> 789)

  // filterKeys
  // x => x.startsWith("J")
  println(aPhoneBook.filterKeys(_.startsWith("J"))) // prints Map(Jim -> 555)

  // mapValues
  println(aPhoneBook.mapValues(num => "1-800-" + num * 10)) // prints Map(Jim -> 1-800-5550, Daniel -> 1-800-7890)

  // Conversions to Other Collections
  println(aPhoneBook.toList) // prints List((Jim,555), (Daniel,789))
  println(List(("Daniel", 555)).toMap) // prints Map(Daniel -> 555)
  val names = List("Bob", "James", "Angela", "Mary", "Miguel", "Daniel", "Jim")
  println(names.groupBy(_.charAt(0))) // name => name.charAt(0)
  // prints Map(J -> List(James, Jim), A -> List(Angela), M -> List(Mary, Miguel), B -> List(Bob), D -> List(Daniel))

  // 1 - What would happen if I had two original entries "Jim" -> 555 and "JIM" -> 990 and you mapped them to lowercase?
  // 2 - Overly simplified social network based on maps:
  //     Person = String
  //     - add a person to the network
  //     - remove
  //     - friend (mutual)
  //     - unfriend (mutual)
  //     - number of friends of a person
  //     - person with most friends
  //     - how many people have no friends
  //     - if there is a social connection between two people (direct or not)

  // 1 - It would map to "jim" -> 990.
  //     Be careful when mapping keys so you don't override values.
  val entry1 = "Jim" -> 555
  val entry2 = "JIM" -> 990
  val entryPair = Map(entry1, entry2)
  println(entryPair) // prints Map(Jim -> 555, JIM -> 990)
  val mappedPair = entryPair.map(e => e._1.toLowerCase -> e._2)
  println(mappedPair) // prints Map(jim -> 990)

  // 2 - Overly simplified social network
  val socialNetwork: Map[String, List[String]] = Map() // empty network.
  def add(network: Map[String, List[String]], person: String): Map[String, List[String]] = ???
  def remove(network: Map[String, List[String]], person: String): Map[String, List[String]] = ???
  def friend(network: Map[String, List[String]], person: String, friend: String): Map[String, List[String]] = ???
  def unfriend(network: Map[String, List[String]], person: String, friend: String): Map[String, List[String]] = ???
  def friendCount(network: Map[String, List[String]], person: String): Int = ???
  def mostPopularPerson(network: Map[String, List[String]]): String = ???
  def lonelyPeopleCount(network: Map[String, List[String]]): Int = ???
  def areConnected(network: Map[String, List[String]], person1: String, person2: String): Boolean = ???

}
