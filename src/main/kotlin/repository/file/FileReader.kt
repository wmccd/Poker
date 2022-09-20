package repository.file

import exceptions.Exceptions
import java.io.File

class FileReader {

    fun read(filename: String): ArrayList<String>{

        val lineList = arrayListOf<String>()

        try {
            val file = File(filename)
            val bufferedReader = file.inputStream().bufferedReader()
            bufferedReader.forEachLine {
                    lineList.add(element = it.trim())
                }
        }catch(ex:Exception){
            throw Exception("${Exceptions.FileExceptions.FILE_DOES_NOT_EXIST}<$filename>" )
        }
        when(lineList.size){
            0 -> throw Exception("${Exceptions.FileExceptions.FILE_IS_EMPTY}<$filename>")
        }

        return lineList
    }
}