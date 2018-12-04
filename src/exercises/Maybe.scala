package exercises

// A small collection of at most ONE element (Maybe[+T])
abstract class Maybe[+T] {
  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def filter(p: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {

}

case class Just[+T](value: T) extends Maybe[T] {

}