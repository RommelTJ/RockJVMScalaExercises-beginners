package com.rommelrico.filesystem.commands

import com.rommelrico.filesystem.State

trait Command {

  def apply(state: State): State

}
