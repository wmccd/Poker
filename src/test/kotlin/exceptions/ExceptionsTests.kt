package exceptions

import org.testng.Assert
import org.testng.annotations.Test

class ExceptionsTests {

    @Test
    fun file_message_correct(){
        Assert.assertEquals("File does not exist", Exceptions.FileExceptions.FILE_DOES_NOT_EXIST)
        Assert.assertEquals("File is empty", Exceptions.FileExceptions.FILE_IS_EMPTY)
    }

    @Test
    fun cardType_message_correct(){
        Assert.assertEquals("Invalid Card Type", Exceptions.CardTypeExceptions.INVALID_CARD_TYPE)
    }

    @Test
    fun suitType_message_correct(){
        Assert.assertEquals("Invalid Suit Type", Exceptions.SuitTypeExceptions.INVALID_SUIT_TYPE)
    }

    @Test
    fun pokerHand_message_correct(){
        Assert.assertEquals("Invalid Card", Exceptions.PokerHandExceptions.INVALID_CARD)
        Assert.assertEquals("Invalid Hand", Exceptions.PokerHandExceptions.INVALID_HAND)

    }
}