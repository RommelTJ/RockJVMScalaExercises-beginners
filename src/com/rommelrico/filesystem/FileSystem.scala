package com.rommelrico.filesystem

import com.rommelrico.filesystem.commands.Command
import com.rommelrico.filesystem.files.Directory

object FileSystem extends App {

  val root = Directory.ROOT
  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
    currentState.show()
    Command.from(newLine).apply(currentState)
  })

}
