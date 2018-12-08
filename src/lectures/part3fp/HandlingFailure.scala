package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  // Create success and failure explicitly
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Fail!"))
  println(aSuccess)
  println(aFailure)

  // Most of the time, you don't have to create those explicitly, because the Try companion object's apply method
  // does it for you.
  def unsafeMethod(): String = throw new RuntimeException("Error!")
  val potentialFailure = Try(unsafeMethod()) // Try objects via the apply method.
  println(potentialFailure) // program doesn't crash!

  // Syntactic sugar
  val anotherPotentialFailure = Try {
    unsafeMethod()
  }
  println(anotherPotentialFailure)

  // Utilities
  println(potentialFailure.isSuccess) // false
  println(potentialFailure.isFailure)

  // orElse
  def backupMethod(): String = "Valid!"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry) // Success(Valid!)

  // if you're designing the API, wrap in a try
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException("BOOM"))
  def betterBackupMethod(): Try[String] = Success("Yay!")
  val betterFallbackTry = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterFallbackTry) // prints Success(Yay!)

  // Map, flatMap, and Filter
  println(aSuccess.map(_ * 2)) // 6
  println(aSuccess.flatMap(x => Success(x * 10))) // Success(30)
  println(aSuccess.filter(_ > 10)) // Failure(java.util.NoSuchElementException: Predicate does not hold for 3)
  // We can use for-comprehensions

  // Exercise
  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try { get(url) }
  }

  object HttpService {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone took the port!")
    }
    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // Ex: If you get the HTML page from the connection, print it to the console i.e. call renderHTML.
  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  val possibleHTML = possibleConnection.flatMap(conn => conn.getSafe("/home"))
  possibleHTML.foreach(renderHTML)

  // Short-hand version
  HttpService.getSafeConnection(hostname, port)
    .flatMap(conn => conn.getSafe("/home"))
    .foreach(renderHTML)

  // For-Comprehension version.
  for {
    conn <- HttpService.getSafeConnection(hostname, port)
    htmlPage <- conn.getSafe("/home")
  } renderHTML(htmlPage)

}
