package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State

class UnknownCommand extends Command {
  override def apply(state: State): State = state.setMessage("Command not found!")
}
