package com.rommelrico.filesystem.files

class File(override val parentPath: String, override val name: String, contents: String)
  extends DirEntry(parentPath, name) {

  override def asDirectory: Directory = ???

  override def getType: String = ???

}
