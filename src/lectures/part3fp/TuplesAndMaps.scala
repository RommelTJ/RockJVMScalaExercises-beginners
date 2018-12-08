package lectures.part3fp

import scala.annotation.tailrec

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
  val socialNetwork: Map[String, Set[String]] = Map() // empty network.
  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    if (network.contains(person)) {
      println("This person is already added!")
      network
    } else {
      network + (person -> Set())
    }
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {

    // Doing it this way to resolve issue with "dangling friendships"
    @tailrec
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }

    if (network.contains(person)) {
      val unfriended = removeAux(network(person), network)
      unfriended - person
    } else {
      println("This person is not in the network!")
      network
    }
  }

  def friend(network: Map[String, Set[String]], person: String, friend: String): Map[String, Set[String]] = {
    if (network.contains(person) && network.contains(friend)) {
      // Mutually connect people.
      val personFriendList: Set[String] = network(person) + friend
      val newPerson = person -> personFriendList

      val friendFriendList: Set[String] = network(friend) + person
      val newFriend = friend -> friendFriendList
      network + newPerson + newFriend
    } else {
      println("Not in network!")
      network
    }
  }

  def unfriend(network: Map[String, Set[String]], person: String, friend: String): Map[String, Set[String]] = {
    if (network.contains(person) && network.contains(friend)) {
      val personFriendList: Set[String] = network(person) - friend
      val newPerson = person -> personFriendList

      val friendFriendList: Set[String] = network(friend) - person
      val newFriend = friend -> friendFriendList

      network + newPerson + newFriend
    } else {
      println("Not in network!")
      network
    }
  }

  def friendCount(network: Map[String, Set[String]], person: String): Int = {
    if (network.contains(person)) network(person).size
    else -1
  }

  def mostPopularPerson(network: Map[String, Set[String]]): String = {
    network.maxBy(p => p._2.size)._1
  }

  def lonelyPeopleCount(network: Map[String, Set[String]]): Int = network.filterKeys(p => network(p).isEmpty).size

  def areConnected(network: Map[String, Set[String]], person1: String, person2: String): Boolean = {

    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }

    bfs(person2, Set(), network(person1) + person1)
  }

  // Testing
  val person1 = "Alice"
  val person2 = "Bob"
  val person3 = "Charles"
  val person4 = "Doug"
  val newNetwork = add(socialNetwork, person1)
  println(newNetwork)
  println(add(newNetwork, person1))
  val newNetwork2 = add(newNetwork, person2)
  println(newNetwork2)
  remove(newNetwork, person3)
  val newNetwork3 = remove(newNetwork2, person1)
  println(newNetwork3)
  val newNetwork4 = add(newNetwork3, person1)
  println(newNetwork4)
  friend(newNetwork4, person1, person3)
  val newNetwork5 = friend(newNetwork4, person1, person2)
  println(newNetwork5)
  val newNetwork6 = add(newNetwork5, person3)
  val newNetwork7 = friend(newNetwork6, person1, person3)
  println(newNetwork7)
  unfriend(newNetwork7, person1, person4)
  val newNetwork8 = unfriend(newNetwork7, person2, person1)
  println(newNetwork8)
  println(friendCount(newNetwork7, person1))
  println(friendCount(newNetwork7, person4))
  val newNetwork9 = friend(newNetwork8, person1, person2)
  println(newNetwork9)
  println(mostPopularPerson(newNetwork9))
  println(lonelyPeopleCount(newNetwork9))
  val newNetwork10 = unfriend(newNetwork9, person1, person2)
  println(lonelyPeopleCount(newNetwork10))
  println(areConnected(newNetwork10, person1, person2))
  println(areConnected(newNetwork10, person1, person3))
  println(areConnected(newNetwork10, person1, person4))

}
