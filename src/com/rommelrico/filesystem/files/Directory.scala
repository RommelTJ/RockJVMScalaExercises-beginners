package com.rommelrico.filesystem.files

class Directory(override val parentPath: String,
                override val name: String,
                val contents: List[DirEntry]) extends DirEntry(parentPath, name) {

  

}
