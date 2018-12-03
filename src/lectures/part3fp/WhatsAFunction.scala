package lectures.part3fp

object WhatsAFunction extends App {
  // Dream: Use a functions as first class elements.
  // Problem: We come from an OOP world.
}

trait Action[A, B] {
  def execute(element: A): B
}
