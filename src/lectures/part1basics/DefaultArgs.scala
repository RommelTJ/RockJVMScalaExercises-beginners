package lectures.part1basics

object DefaultArgs extends App {

  // Using a default value.
  def tailRecFactorial(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else tailRecFactorial(n - 1, n * acc)

  val fact10 = tailRecFactorial(10, 1)
  println(fact10)
  val fact11 = tailRecFactorial(11)
  println(fact11)

  // Dummy Example to show default values that should be omitted should be at the end or you should name the arguments.
  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving Picture")
  savePicture("jpg", 800, 600)
  savePicture(height = 600, width = 800) // This works, even if out of order, because they're labeled.
  // savePicture(800, 600) // This doesn't work.
  // savePicture(800) // This doesn't work.
  savePicture(width = 800) // This works.
  // Pass in every leading argument, or name the arguments.


}
