package exceptions

import org.testng.Assert
import org.testng.annotations.Test

class ExceptionsTests {

    @Test
    fun file_message_correct(){

        Assert.assertEquals("File does not exist", Exceptions.File.FILE_DOES_NOT_EXIST)
        Assert.assertEquals("File is empty", Exceptions.File.FILE_IS_EMPTY)

    }
}