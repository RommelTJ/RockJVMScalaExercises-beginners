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
