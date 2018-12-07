package lectures.part3fp

import scala.util.Random

object WorkingWithOptions extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  // Options were invented to deal with unsafe APIs
  def unsafeMethod(): String = null
  // val result = Some(unsafeMethod()) // WRONG, Some should always have a valid value inside.
  val correct = Option(unsafeMethod()) // Generate Some or None.
  println(correct) // Prints None

  // Chained Methods
  def backupMethod(): String = "A valid result"
  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)

  // Design Unsafe APIs
  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A new result")
  val betterChainedResult = betterUnsafeMethod().orElse(betterBackupMethod())
  println(betterChainedResult)

  // Functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // unsafe, do not use this.

  // map, flatMap, and filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10)) // Returns None
  println(myFirstOption.flatMap(x => Option(x * 10))) // prints Some(40)

  // For-Comprehensions.
  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // Connect to some server.
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }

  }

  // Try to establish a connection, if so, print the connect method.
  val host = config.get("host")
  val port = config.get("port")
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  connectionStatus.foreach(println)

  // Another solution using chained calls
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)

  // Another solution using for-comprehensions
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield connection.connect
  forConnectionStatus.foreach(println)

}
