package com.rommelrico.filesystem

import java.util.Scanner

import com.rommelrico.filesystem.commands.Command
import com.rommelrico.filesystem.files.Directory

object FileSystem extends App {

  val root = Directory.ROOT
  var state = State(root, root)
  val scanner = new Scanner(System.in)

  while(true) {
    state.show()
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }

}
