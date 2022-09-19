package enumerations

import exceptions.Exceptions
import org.testng.Assert
import org.testng.annotations.Test
import java.lang.Exception
import java.util.concurrent.CountDownLatch

class SuitTypeTest {


    @Test
    fun convertFromValue_invalid_exception(){

        //assemble
        val value = 'B'
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = Exceptions.SuitType.INVALID_SUIT_TYPE

        //act
        try {
            SuitType.convert(value)
        }catch(ex: Exception){
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun convertFromValue_H_Heart(){

        //assemble
        val value = 'H'
        val expected = SuitType.HEART

        //act
        val actual =  SuitType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_D_Diamond(){

        //assemble
        val value = 'D'
        val expected = SuitType.DIAMOND

        //act
        val actual =  SuitType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_C_Club(){

        //assemble
        val value = 'C'
        val expected = SuitType.CLUB

        //act
        val actual =  SuitType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_S_Spade(){

        //assemble
        val value = 'S'
        val expected = SuitType.SPADE

        //act
        val actual =  SuitType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }
}