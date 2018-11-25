package exercises

/**
  * head = first element of this list.
  * tail = remainder of this list.
  * isEmpty = is this list empty.
  * add(int) => new list with this element added
  * toString => a string representation of the list.
  */
abstract class MyList {

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList

  override def toString: String = super.toString

}

object Empty extends MyList {
  override def head: Int = throw new NoSuchElementException
  override def tail: MyList = throw new NoSuchElementException
  override def isEmpty: Boolean = true
  override def add(element: Int): MyList = new Cons(element, Empty)
}

class Cons(h: Int, t: MyList) extends MyList {
  override def head: Int = h
  override def tail: MyList = t
  override def isEmpty: Boolean = false
  override def add(element: Int): MyList = new Cons(element, this)
}
