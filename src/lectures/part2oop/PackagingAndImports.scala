package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming => Wut}
// import playground._

import java.util.{Date => JavaDate}
import java.sql.{Date => SQLDate}

object PackagingAndImports extends App {

  // Package members are accessible by their simple name.
  val write = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package.
  // val princess = new playground.Cinderella // fully-qualified class name.
  val princess = new Princess

  // Packages are in a hierarchy.
  // Matching folder structure.

  // Package Object
  sayHello()
  println(SPEED_OF_LIGHT)

  // Imports
  val prince = new Wut

  val javaDate = new JavaDate
  val sqlDate = new SQLDate(2018, 5, 4)

}
