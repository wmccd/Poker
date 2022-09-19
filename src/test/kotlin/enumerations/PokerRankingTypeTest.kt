package enumerations

import org.testng.Assert
import org.testng.annotations.Test

class PokerRankingTypeTest {

    @Test
    fun ranking_royalFlush_correctValues(){
        //assemble
        val expectedDescription = "Straight Royal Flush"
        val rankingType = PokerRankingType.STRAIGHT_ROYAL_FLUSH

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_straightFlush_correctValues(){
        //assemble
        val expectedDescription = "Straight Flush"
        val rankingType = PokerRankingType.STRAIGHT_FLUSH

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_fourOfAKind_correctValues(){
        //assemble
        val expectedDescription = "Four of a Kind"
        val rankingType = PokerRankingType.FOUR_OF_A_KIND

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_fullHouse_correctValues(){
        //assemble
        val expectedDescription = "Full House"
        val rankingType = PokerRankingType.FULL_HOUSE

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_flush_correctValues(){
        //assemble
        val expectedDescription = "Flush"
        val rankingType = PokerRankingType.FLUSH

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_straight_correctValues(){
        //assemble
        val expectedDescription = "Straight"
        val rankingType = PokerRankingType.STRAIGHT

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_threeOfAKind_correctValues(){
        //assemble
        val expectedDescription = "Three of a Kind"
        val rankingType = PokerRankingType.THREE_OF_A_KIND

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_twoPair_correctValues(){
        //assemble
        val expectedDescription = "Two Pair"
        val rankingType = PokerRankingType.TWO_PAIR

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_onePair_correctValues(){
        //assemble
        val expectedDescription = "One Pair"
        val rankingType = PokerRankingType.ONE_PAIR

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }

    @Test
    fun ranking_highCard_correctValues(){
        //assemble
        val expectedDescription = "High Card"
        val rankingType = PokerRankingType.HIGH_CARD

        //act
        //assert
        Assert.assertEquals(rankingType.description, expectedDescription)
    }




}