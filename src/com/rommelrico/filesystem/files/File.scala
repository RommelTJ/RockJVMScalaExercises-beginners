package com.rommelrico.filesystem.files

import com.rommelrico.filesystem.FileSystemException

class File(override val parentPath: String, override val name: String, contents: String)
  extends DirEntry(parentPath, name) {

  override def asDirectory: Directory = throw new FileSystemException("A file cannot be converted to a Directory!")
  
  override def asFile: File = this

  override def getType: String = "File"

}
