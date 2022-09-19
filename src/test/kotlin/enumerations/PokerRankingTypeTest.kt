package enumerations

import org.testng.Assert
import org.testng.annotations.Test

class PokerRankingTypeTest {

    @Test
    fun ranking_royalFlush_correctValues(){
        //assemble
        val expectedRank = 1
        val expectedDescription = "Royal Flush"
        val rankingType = PokerRankingType.ROYAL_FLUSH

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_straightFlush_correctValues(){
        //assemble
        val expectedRank = 2
        val expectedDescription = "Straight Flush"
        val rankingType = PokerRankingType.STRAIGHT_FLUSH

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_fourOfAKind_correctValues(){
        //assemble
        val expectedRank = 3
        val expectedDescription = "Four of a Kind"
        val rankingType = PokerRankingType.FOUR_OF_A_KIND

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_fullHouse_correctValues(){
        //assemble
        val expectedRank = 4
        val expectedDescription = "Full House"
        val rankingType = PokerRankingType.FULL_HOUSE

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_flush_correctValues(){
        //assemble
        val expectedRank = 5
        val expectedDescription = "Flush"
        val rankingType = PokerRankingType.FLUSH

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_straight_correctValues(){
        //assemble
        val expectedRank = 6
        val expectedDescription = "Straight"
        val rankingType = PokerRankingType.STRAIGHT

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_threeOfAKind_correctValues(){
        //assemble
        val expectedRank = 7
        val expectedDescription = "Three of a Kind"
        val rankingType = PokerRankingType.THREE_OF_A_KIND

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_twoPair_correctValues(){
        //assemble
        val expectedRank = 8
        val expectedDescription = "Two Pair"
        val rankingType = PokerRankingType.TWO_PAIR

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_onePair_correctValues(){
        //assemble
        val expectedRank = 9
        val expectedDescription = "One Pair"
        val rankingType = PokerRankingType.ONE_PAIR

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_highCard_correctValues(){
        //assemble
        val expectedRank = 10
        val expectedDescription = "High Card"
        val rankingType = PokerRankingType.HIGH_CARD

        //act
        //assert
        Assert.assertEquals(rankingType.rank, expectedRank)
        Assert.assertEquals(rankingType.description, expectedDescription)
    }



}