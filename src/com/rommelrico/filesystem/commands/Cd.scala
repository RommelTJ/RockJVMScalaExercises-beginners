package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State
import com.rommelrico.filesystem.files.{DirEntry, Directory}

class Cd(dir: String) extends Command {

  override def apply(state: State): State = {
    // 1 - Find Root
    val root = state.root
    val wd = state.wd

    // 2 - Find Absolute Path of the directory I want to CD to.
    val absolutePath = {
      if (dir.startsWith(Directory.SEPARATOR)) dir
      else if (wd.isRoot) wd.path + dir
      else wd.path + Directory.SEPARATOR + dir
    }

    // 3 - Find the directory to CD to given the path.
    val destinationDirectory = doFindEntry(root, absolutePath)

    // 4 - Change the state given the new directory.
    if (destinationDirectory == null || !destinationDirectory.isDirectory) state.setMessage(s"$dir: no such directory!")
    else State(root, destinationDirectory.asDirectory)

  }

  def doFindEntry(root: Directory, path: String): DirEntry = ???

}
