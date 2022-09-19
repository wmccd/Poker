package pokerlibrary

import constants.PokerConstants
import enumerations.PokerRankingType
import models.PokerHand
import org.testng.Assert
import org.testng.annotations.Test

class PokerHandRankerTest {

    @Test
    fun checkForHighCard_threeHigh_threeHighReturned(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 4S 6C 8D TH"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = "TEN High"

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun checkForFourOfAKind_four_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 2S 2C 2D 3H"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.FOUR_OF_A_KIND.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

}