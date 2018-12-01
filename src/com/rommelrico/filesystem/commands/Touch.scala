package com.rommelrico.filesystem.commands
import com.rommelrico.filesystem.State
import com.rommelrico.filesystem.files.{DirEntry, File}

class Touch(name: String) extends CreateEntry(name){
  override def createSpecificEntry(state: State): DirEntry = File.empty(state.wd.path, name)
}
