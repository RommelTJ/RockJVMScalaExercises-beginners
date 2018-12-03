package lectures.part3fp

object WhatsAFunction extends App {
  // Dream: Use a functions as first class elements.
  // Problem: We come from an OOP world.
}

trait MyFunction[A, B] {
  def apply(element: A): B
}
