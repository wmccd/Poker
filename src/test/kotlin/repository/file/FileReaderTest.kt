package repository.file

import exceptions.Exceptions
import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.CountDownLatch

class FileReaderTest {

    @Test
    fun fileOpen_badName_fileDoesNotExistException() {

        //assemble
        val fileReader = FileReader()
        val filename = ""
        val expectedMessage = "${Exceptions.FileExceptions.FILE_DOES_NOT_EXIST}<$filename>"
        val expectedCount = 0L
        val countDownLatch = CountDownLatch(1)

        //act
        try {
            fileReader.read(filename)
        } catch (ex: Exception) {
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun fileOpen_emptyFile_fileIsEmptyException(){

        //assemble
        val fileReader = FileReader()
        val filename = "./src/test/resources/empty.txt"
        val expectedMessage = "${Exceptions.FileExceptions.FILE_IS_EMPTY}<$filename>"
        val expectedCount = 0L
        val countDownLatch = CountDownLatch(1)

        //act
        try {
            fileReader.read(filename)
        }catch (ex: Exception){
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun fileOpen_singleLine_singleItem(){

        //assemble
        val fileReader = FileReader()
        val filename = "./src/test/resources/single.txt"
        val expectedSize = 1
        val expectedLine = "Bobbins"
        var actual = arrayListOf<String>()

        //act
        try {
            actual = fileReader.read(filename)
        }catch (ex: Exception){
            Assert.fail("Unexpectedly in catch block ${ex.message}")
        }

        //assert
        Assert.assertEquals(actual.size, expectedSize)
        Assert.assertEquals(actual[0], expectedLine)
    }

    @Test
    fun fileOpen_multipleLines_multipleItems(){

        //assemble
        val fileReader = FileReader()
        val filename = "./src/test/resources/multiple.txt"
        val expectedSize = 3
        val expectedLine0 = "The"
        val expectedLine1 = "Mighty"
        val expectedLine2 = "Bobbins"
        var actual = arrayListOf<String>()

        //act
        try {
            actual = fileReader.read(filename)
        }catch (ex: Exception){
            Assert.fail("Unexpectedly in catch block ${ex.message}")
        }

        //assert
        Assert.assertEquals(actual.size, expectedSize)
        Assert.assertEquals(actual[0], expectedLine0)
        Assert.assertEquals(actual[1], expectedLine1)
        Assert.assertEquals(actual[2], expectedLine2)

    }

}