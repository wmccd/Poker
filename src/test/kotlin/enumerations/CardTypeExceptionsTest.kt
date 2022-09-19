package enumerations

import exceptions.Exceptions
import org.testng.Assert
import org.testng.annotations.Test
import java.lang.Exception
import java.util.concurrent.CountDownLatch

class CardTypeExceptionsTest {

    @Test
    fun convertFromValue_invalid_exception(){

        //assemble
        val value = 'B'
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = Exceptions.CardTypeExceptions.INVALID_CARD_TYPE

        //act
        try {
            CardType.convert(value)
        }catch(ex: Exception){
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun convertFromValue_2_TWO(){

        //assemble
        val value = '2'
        val expected = CardType.TWO

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_3_THREE(){

        //assemble
        val value = '3'
        val expected = CardType.THREE

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_4_FOUR(){

        //assemble
        val value = '4'
        val expected = CardType.FOUR

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_5_FIVE(){

        //assemble
        val value = '5'
        val expected = CardType.FIVE

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_6_SIX(){

        //assemble
        val value = '6'
        val expected = CardType.SIX

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_7_SEVEN(){

        //assemble
        val value = '7'
        val expected = CardType.SEVEN

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_8_EIGHT(){

        //assemble
        val value = '8'
        val expected = CardType.EIGHT

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_9_NINE(){

        //assemble
        val value = '9'
        val expected = CardType.NINE

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_T_TEN(){

        //assemble
        val value = 'T'
        val expected = CardType.TEN

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_J_JACK(){

        //assemble
        val value = 'J'
        val expected = CardType.JACK

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_Q_QUEEN(){

        //assemble
        val value = 'Q'
        val expected = CardType.QUEEN

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_K_KING(){

        //assemble
        val value = 'K'
        val expected = CardType.KING

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun convertFromValue_A_ACE(){

        //assemble
        val value = 'A'
        val expected = CardType.ACE

        //act
        val actual =  CardType.convert(value)

        //assert
        Assert.assertEquals(actual, expected)
    }

}