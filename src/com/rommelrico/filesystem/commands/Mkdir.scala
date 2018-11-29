package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State
import com.rommelrico.filesystem.files.Directory

class Mkdir(name: String) extends Command {

  override def apply(state: State): State = {
    val wd = state.wd
    if (wd.hasEntry(name)) {
      state.setMessage(s"Entry $name already exists!")
    } else if (name.contains(Directory.SEPARATOR)) {
      state.setMessage(s"$name must not contain separators!")
    } else if (checkIllegal(name)) {
      state.setMessage(s"$name: illegal entry name!")
    } else {
      doMkdir(name, state)
    }
  }

  def checkIllegal(name: String): Boolean = {
    name.contains(".")
  }

  def doMkdir(name: String, state: State): State = {
    val wd = state.wd
    val fullPath = wd.path

    // 1. Getting all the directories in the full Path.
    val allDirsInPath = wd.getAllFoldersInPath

    // 2. Create a new directory entry in the wd.
    val newDir = Directory.empty(wd.path, name)

    // 3. Updating the whole directory structure starting from the root. (IMMUTABLE)
    val newRoot = updateStructure(state.root, allDirsInPath, newDir)

  }

}
