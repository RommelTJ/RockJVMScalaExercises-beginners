package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State
import com.rommelrico.filesystem.files.Directory

import scala.annotation.tailrec

class Echo(args: Array[String]) extends Command {

  override def apply(state: State): State = {
    if (args.isEmpty) state
    else if (args.length == 1) state.setMessage(args(0))
    else {
      val operator = args(args.length - 2)
      val filename = args(args.length - 1)
      val contents = createContent(args, args.length - 2)

      if (">>".equals(operator)) doEcho(state, contents, filename, append = true)
      else if (">".equals(operator)) doEcho(state, contents, filename, append = false)
      else state.setMessage(createContent(args, args.length))
    }
  }

  // topIndex NON-INCLUSIVE!
  def createContent(args: Array[String], topIndex: Int): String = {

    @tailrec
    def createContentHelper(currentIndex: Int, accumulator: String): String = {
      if (currentIndex >= topIndex) accumulator
      else createContentHelper(currentIndex + 1, accumulator + " " + args(currentIndex))
    }

    createContentHelper(0, "")
  }

  def doEcho(state: State, content: String, filename: String, append: Boolean): State = {
    if (filename.contains(Directory.SEPARATOR)) state.setMessage("Echo: filename must not contain separators.")
    else {
      val newRoot: Directory = ???
      if (newRoot == state.root) state.setMessage(s"$filename: no such file!")
      else State(newRoot, newRoot.findDescendant(state.wd.getAllFoldersInPath))
    }
  }

}
