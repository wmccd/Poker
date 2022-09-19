package pokerlibrary

import enumerations.PokerRankingType
import org.testng.Assert
import org.testng.annotations.Test

class PokerHandRankerTest {

    @Test
    fun rank_threeHigh_threeHighReturned(){

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
    fun rank_fourOfAKind_true(){

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

    @Test
    fun rank_threeOfAKind_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 2S 2C 4D 3H"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.THREE_OF_A_KIND.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_fullHouse_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 2S 2C 3D 3H"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.FULL_HOUSE.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_twoPair_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 2S 4C 3D 3H"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.TWO_PAIR.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_onePair_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 2S 4C 5D 6H"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.ONE_PAIR.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_flush_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 3H 6H 9H JH"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.FLUSH.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_straightWithoutAce_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 3H 4D 5H 6H"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.STRAIGHT.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_straightWithLowAce_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 3H 4D 5H AH"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.STRAIGHT.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_straightWithHighAce_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "AH KD QH JC TS"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.STRAIGHT.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_straightFlushWithoutAce_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 3H 4H 5H 6H"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.STRAIGHT_FLUSH.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_straightFlushWithLowAce_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "2H 3H 4H 5H AH"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.STRAIGHT_FLUSH.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }

    @Test
    fun rank_straightFlushWithHighAce_true(){

        //assemble
        val pokerHandRanker = PokerHandRanker()
        val rawHand = "AH KH QH JH TH"
        val pokerHand = PokerHandCreator().tryGenerate(
            rawHand = rawHand
        )
        val expected = PokerRankingType.STRAIGHT_ROYAL_FLUSH.description

        //act
        val actual = pokerHandRanker.rank(
            pokerHand = pokerHand
        )

        //assert
        Assert.assertEquals(actual, expected)
    }
}