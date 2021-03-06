package exercises

/**
  * head = first element of this list.
  * tail = remainder of this list.
  * isEmpty = is this list empty.
  * add(int) => new list with this element added
  * toString => a string representation of the list.
  */
abstract class MyList[+A] {

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]

  // Polymorphic Method.
  override def toString: String = s"[$printElements]"

  def printElements: String

  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  // Concatenation
  def ++[B >: A](list: MyList[B]): MyList[B]

  // Higher-Order Functions
  def foreach(f: A => Unit): Unit
  def sort(compare: (A, A) => Int): MyList[A]
  def zipwith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C]
  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException
  override def tail: MyList[Nothing] = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add[B >: Nothing](element: B): MyList[B] = Cons(element, Empty)

  def printElements: String = ""

  // Higher-Order Functions
  override def map[B](transformer: Nothing => B): MyList[B] = Empty
  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  // HOFs
  override def foreach(f: Nothing => Unit): Unit = ()
  override def sort(compare: (Nothing, Nothing) => Int): MyList[Nothing] = Empty
  override def zipwith[B, C](list: MyList[B], zip: (Nothing, B) => C): MyList[C] = {
    if (!list.isEmpty) throw new RuntimeException("Lists do not have the same length.")
    else Empty
  }
  override def fold[B](start: B)(operator: (B, Nothing) => B): B = start

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def head: A = h
  override def tail: MyList[A] = t
  override def isEmpty: Boolean = false
  override def add[B >: A](element: B): MyList[B] = Cons(element, this)

  def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  }

  override def map[B](transformer: A => B): MyList[B] = {
    Cons(transformer(h), t.map(transformer))
  }

  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)

  // HOFs
  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) Cons(x, sortedList)
      else Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipwith[B, C](list: MyList[B], zip: (A, B) => C): MyList[C] = {
    if (list.isEmpty) throw new RuntimeException("Lists do not have the same length.")
    else Cons(zip(h, list.head), t.zipwith(list.tail, zip))
  }

  override def fold[B](start: B)(operator: (B, A) => B): B = t.fold(operator(start, h))(operator)

}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val listOfIntegers2: MyList[Int] = Cons(1, Cons(2, Cons(3, Empty)))
  val anotherListOfIntegers: MyList[Int] = Cons(1, Cons(4, Cons(5, Empty)))
  val anotherListOfIntegers2: MyList[Int] = Cons(1, Cons(4, Empty))
  val listOfStrings: MyList[String] = Cons("Hello", Cons("Scala", Empty))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map((element: Int) => element * 2).toString) // Prints [2 4 6]

  println(listOfIntegers.filter((element: Int) => element % 2 == 0).toString) // Prints [2]

  println((listOfIntegers ++ anotherListOfIntegers).toString) // [1 2 3 1 4 5]
  println(listOfIntegers.flatMap((element: Int) => Cons(element, Cons(element + 1, Empty))).toString) // Prints [1 2 2 3 3 4]

  println(listOfIntegers == listOfIntegers2)

  listOfIntegers.foreach(x => println(x)) // prints 1 2 3
  listOfIntegers.foreach(println) // prints 1 2 3
  println(listOfIntegers.sort((x, y) => y - x)) // prints [3 2 1]
  println(anotherListOfIntegers2.zipwith[String, String](listOfStrings, _ + " " + _)) // prints [1 Hello 4 Scala]
  println(listOfIntegers.fold(0)(_ + _)) // prints 6

  // for comprehensions
  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield s"$n-$string"
  println(combinations)

}