package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State

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
  def createContent(args: Array[String], topIndex: Int): String = ???

  def doEcho(state: State, content: String, filename: String, append: Boolean): State = ???

}
