package exercises

// A small collection of at most ONE element (Maybe[+T])
abstract class Maybe[+T] {

}

case object MaybeNot extends Maybe[Nothing] {

}

case class Just[+T](value: T) extends Maybe[T] {

}