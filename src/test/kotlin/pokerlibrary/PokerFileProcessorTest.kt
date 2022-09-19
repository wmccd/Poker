package pokerlibrary

import org.testng.Assert
import org.testng.annotations.Test
import java.util.concurrent.CountDownLatch

class PokerFileProcessorTest {

    @Test
    fun process_emptyFile_failure(){

        //assemble
        val pokerFileProcessor = PokerFileProcessor()
        val filename = "./src/test/resources/does_not_exist.txt"
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = "FILE ISSUE: File does not exist<${filename}>"

        fun success(result: String){
            Assert.fail("Unexpectedly in success block")
        }
        fun failure(message: String){
            //assert
            Assert.assertEquals(message, expectedMessage)

            countDownLatch.countDown()
        }

        //act
        pokerFileProcessor.process(
            filename = filename,
            success = ::success,
            failure = ::failure
        )

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }
    @Test
    fun process_fileWithValidHand_success(){

        //assemble
        val pokerFileProcessor = PokerFileProcessor()
        val filename = "./src/test/resources/valid_single_hand.txt"
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedResult = "2H 2S 2C 2D 3H => Four of a Kind"

        fun success(result: String){
            //assert
            Assert.assertEquals(result, expectedResult)

            countDownLatch.countDown()
        }
        fun failure(message: String){
            Assert.fail("Unexpectedly in failure block")
        }

        //act
        pokerFileProcessor.process(
            filename = filename,
            success = ::success,
            failure = ::failure
        )

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun process_fileWithInvalidFourCardHand_failure(){

        //assemble
        val pokerFileProcessor = PokerFileProcessor()
        val filename = "./src/test/resources/invalid_four_cards.txt"
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = "HAND ISSUE:<2H 4S 6C 8D> Invalid Hand"

        fun success(result: String){
            Assert.fail("Unexpectedly in success block")

        }
        fun failure(message: String){
            //assert
            Assert.assertEquals(message, expectedMessage)

            countDownLatch.countDown()
        }

        //act
        pokerFileProcessor.process(
            filename = filename,
            success = ::success,
            failure = ::failure
        )

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun process_fileWithInvalidSuit_failure(){

        //assemble
        val pokerFileProcessor = PokerFileProcessor()
        val filename = "./src/test/resources/invalid_suit.txt"
        val countDownLatch = CountDownLatch(1)
        val expectedCount = 0L
        val expectedMessage = "HAND ISSUE:<2H 4S 6C 8D 5T> Invalid Card<5T>"

        fun success(result: String){
            Assert.fail("Unexpectedly in success block")

        }
        fun failure(message: String){
            //assert
            Assert.assertEquals(message, expectedMessage)

            countDownLatch.countDown()
        }

        //act
        pokerFileProcessor.process(
            filename = filename,
            success = ::success,
            failure = ::failure
        )

        //assert
        Assert.assertEquals(countDownLatch.count, expectedCount)
    }

    @Test
    fun process_fileWith3ValidAnd5Invalid_totalsCorrect(){

        //assemble
        val pokerFileProcessor = PokerFileProcessor()
        val filename = "./src/test/resources/mixture_valid_and_invalid.txt"
        val countDownLatch = CountDownLatch(8)
        val expectedCount = 0L
        val expectedSuccess = 3
        val expectedFailure = 5
        var successCount: Int = 0
        var failureCount: Int = 0

        fun success(result: String){
            successCount++
            countDownLatch.countDown()
        }
        fun failure(message: String){
            failureCount++
            countDownLatch.countDown()
        }

        //act
        pokerFileProcessor.process(
            filename = filename,
            success = ::success,
            failure = ::failure
        )

        //assert
        countDownLatch.await()
        Assert.assertEquals(countDownLatch.count, expectedCount)
        Assert.assertEquals(successCount, expectedSuccess)
        Assert.assertEquals(failureCount, expectedFailure)
    }
}