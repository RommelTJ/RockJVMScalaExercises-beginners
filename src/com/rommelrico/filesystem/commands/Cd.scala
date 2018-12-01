package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State
import com.rommelrico.filesystem.files.{DirEntry, Directory}

import scala.annotation.tailrec

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

  def doFindEntry(root: Directory, path: String): DirEntry = {

    @tailrec
    def findEntryHelper(currentDirectory: Directory, path: List[String]): DirEntry = {
      if (path.isEmpty || path.head.isEmpty) currentDirectory
      else if (path.tail.isEmpty) currentDirectory.findEntry(path.head)
      else {
        val nextDir = currentDirectory.findEntry(path.head)
        if (nextDir == null || !nextDir.isDirectory) null
        else findEntryHelper(nextDir.asDirectory, path.tail)
      }
    }

    def collapseRelativeTokens(path: List[String], result: List[String]): List[String] = ???

    // 1 - Get the tokens.
    val tokens: List[String] = path.substring(1).split(Directory.SEPARATOR).toList

    // 1.5 - Eliminate or collapse relative tokens
    val newTokens = collapseRelativeTokens(tokens, List())

    // 2 - Navigate to the Correct Entry.
    findEntryHelper(root, tokens)
  }

}
