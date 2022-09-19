package pokerlibrary

import exceptions.Exceptions
import models.PokerHand
import org.testng.Assert
import org.testng.annotations.Test
import java.lang.Exception
import java.util.concurrent.CountDownLatch

class PokerHandCreatorTest {

    @Test
    fun tryGenerate_empty_invalidHand(){

        //assemble
        val pokerHandCreator = PokerHandCreator()
        val rawHand = ""
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = "${Exceptions.PokerHandExceptions.INVALID_HAND}<${rawHand}>"

        //act
        try{
            pokerHandCreator.tryGenerate(rawHand)
        }catch(ex:Exception){
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun tryGenerate_length13_invalidHand(){

        //assemble
        val pokerHandCreator = PokerHandCreator()
        val rawHand = "1234567890ABC"
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = "${Exceptions.PokerHandExceptions.INVALID_HAND}<${rawHand}>"

        //act
        try{
            pokerHandCreator.tryGenerate(rawHand)
        }catch(ex:Exception){
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun tryGenerate_length15_invalidHand(){

        //assemble
        val pokerHandCreator = PokerHandCreator()
        val rawHand = "1234567890ABCYZ"
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = "${Exceptions.PokerHandExceptions.INVALID_HAND}<${rawHand}>"

        //act
        try{
            pokerHandCreator.tryGenerate(rawHand)
        }catch(ex:Exception){
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun tryGenerate_validCards_pokerHandCorrectSize(){

        //assemble
        val pokerHandCreator = PokerHandCreator()
        lateinit var pokerHand: PokerHand
        val rawHand = "2H 3H 4H 5H 6H"
        val expectedSize = 5

        //act
        try{
            pokerHand = pokerHandCreator.tryGenerate(rawHand)
        }catch(ex:Exception){
            Assert.fail("Unexpectedly in catch block")
        }

        //assert
        Assert.assertEquals(pokerHand.hand.size, expectedSize)
    }

    @Test
    fun tryGenerate_validCards_pokerHandCorrectContents(){

        //assemble
        val pokerHandCreator = PokerHandCreator()
        lateinit var pokerHand: PokerHand
        val rawHand = "2H 3H 4H 5H 6H"

        //act
        try{
            pokerHand = pokerHandCreator.tryGenerate(rawHand)
        }catch(ex:Exception){
            Assert.fail("Unexpectedly in catch block")
        }

        //assert
        pokerHand.hand.forEach {
            val rawCard = "${it.cardType.cardValue}${it.suitType.suitValue}"
            Assert.assertTrue(rawHand.contains(rawCard), "Check <$rawCard> is in $rawHand")
        }
    }


    @Test
    fun tryGenerate_duplicateCard_invalidHand(){

        //assemble
        val pokerHandCreator = PokerHandCreator()
        val rawHand = "2H 2H 3H 4H 5H"
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = "${Exceptions.PokerHandExceptions.INVALID_HAND}<${rawHand}>"

        //act
        try{
            pokerHandCreator.tryGenerate(rawHand)
        }catch(ex:Exception){
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun tryGenerate_invalidCard_invalidCard(){

        //assemble
        val pokerHandCreator = PokerHandCreator()
        val rawHand = "1H 2H 3H 4H 5H"
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = "${Exceptions.PokerHandExceptions.INVALID_CARD}<1H>"

        //act
        try{
            pokerHandCreator.tryGenerate(rawHand)
        }catch(ex:Exception){
            countDownLatch.countDown()

            //assert
            Assert.assertEquals(ex.message, expectedMessage)
        }

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }
}