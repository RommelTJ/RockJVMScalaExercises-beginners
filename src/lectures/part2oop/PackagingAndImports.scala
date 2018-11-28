package lectures.part2oop

import playground.Cinderella

object PackagingAndImports extends App {

  // Package members are accessible by their simple name.
  val write = new Writer("Daniel", "RockTheJVM", 2018)

  // import the package.
  // val princess = new playground.Cinderella // fully-qualified class name.
  val princess = new Cinderella

  // Packages are in a hierarchy.
  // Matching folder structure.

  // Package Object

}
