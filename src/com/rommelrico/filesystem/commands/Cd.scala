package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State

class Cd(dir: String) extends Command {

  override def apply(state: State): State = {
    // 1 - Find Root

    // 2 - Find Absolute Path of the directory I want to CD to.

    // 3 - Find the directory to CD to given the path.

    // 4 - Change the state given the new directory.

  }

}
