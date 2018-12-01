package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State
import com.rommelrico.filesystem.files.Directory

class Rm(name: String) extends Command {

  override def apply(state: State): State = {
    // 1 - Get working directory.
    val wd = state.wd

    // 2 - Get Absolute Path.
    val absolutePath = {
      if (name.startsWith(Directory.SEPARATOR)) name
      else if (wd.isRoot) wd.path + name
      else wd.path + Directory.SEPARATOR + name
    }

    // 3 - Do Some checks.
    if (Directory.ROOT_PATH.equals(absolutePath)) state.setMessage("Nuclear war not supported yet!")
    else doRm(state, absolutePath)
  }

  def doRm(state: State, path: String): State = {

    def rmHelper(currentDirectory: Directory, path: List[String]): Directory = {
      if (path.isEmpty) currentDirectory
      else if (path.tail.isEmpty) currentDirectory.removeEntry(path.head)
      else {
        val nextDirectory = currentDirectory.findDescendant(path.head)
        if (!nextDirectory.isDirectory) currentDirectory
        else {
          val newNextDirectory = rmHelper(nextDirectory.asDirectory, path.tail)
          if (newNextDirectory == nextDirectory) currentDirectory
          else currentDirectory.replaceEntry(path.head, newNextDirectory)
        }
      }
    }

    // 4 - Get or find the entry to remove and update structure like we do for mkdir.
    val tokens = path.substring(1).split(Directory.SEPARATOR).toList
    val newRoot: Directory = rmHelper(state.root, tokens)
    if (newRoot == state.root) state.setMessage(s"$path: no such file or directory.")
    else State(newRoot, newRoot.findDescendant(state.wd.path.substring(1)))
  }

}
