package pokerlibrary

import enumerations.CardType
import enumerations.PokerRankingType
import models.PokerCard
import models.PokerHand

class PokerHandRanker {

    fun rank(pokerHand: PokerHand): String {

        if(containsRoyalStraightFlush(pokerHand)){
            return PokerRankingType.STRAIGHT_ROYAL_FLUSH.description
        }

        if(containsStraightFlush(pokerHand)){
            return PokerRankingType.STRAIGHT_FLUSH.description
        }

        if(containsFourOfAKind(pokerHand)){
            return PokerRankingType.FOUR_OF_A_KIND.description
        }

        if(containsFullHouse(pokerHand)){
            return PokerRankingType.FULL_HOUSE.description
        }

        if(containsFlush(pokerHand)){
            return PokerRankingType.FLUSH.description
        }

        if(containsStraight(pokerHand)){
            return PokerRankingType.STRAIGHT.description
        }

        if(containsThreeOfAKind(pokerHand)){
            return PokerRankingType.THREE_OF_A_KIND.description
        }

        if(containsTwoPair(pokerHand)){
            return PokerRankingType.TWO_PAIR.description
        }

        if(containsOnePair(pokerHand)){
            return PokerRankingType.ONE_PAIR.description
        }

        return containsHighCard(pokerHand = pokerHand)
    }


    private fun containsRoyalStraightFlush(pokerHand: PokerHand): Boolean{

        val sortedCards = pokerHand.hand.sortedBy { it.cardType }
        if (sortedCards[0].cardType != CardType.TEN)
            return false

        return (containsStraightFlush(pokerHand))
    }

    private fun containsStraightFlush(pokerHand: PokerHand): Boolean{
        return (containsStraight(pokerHand) && containsFlush(pokerHand))
    }

    private fun containsFourOfAKind(pokerHand: PokerHand): Boolean{
        val groupedCards = pokerHand.hand.groupBy { it.cardType }
        var fourFound = false
        groupedCards.forEach { (cardType, list) ->
            if(list.size == 4)
                fourFound = true
        }
        return fourFound
    }

    private fun containsFlush(pokerHand: PokerHand): Boolean{
        val groupedSuits = pokerHand.hand.groupBy { it.suitType }
        return (groupedSuits.size == 1)
    }

    private fun containsStraight(pokerHand: PokerHand): Boolean{
        val groupedCards = pokerHand.hand.groupBy { it.cardType }
        if (groupedCards.size != 5)
            return false

        val sortedCards = pokerHand.hand.sortedBy { it.cardType }
        if (sortedCards[0].cardType.ordinal + 4 == sortedCards[4].cardType.ordinal )
            return true
        if (checkIfStraightContainsLowAce(sortedCards))
            return true

        return false
    }

    private fun checkIfStraightContainsLowAce(sortedCards: List<PokerCard>) =
        (sortedCards[0].cardType.ordinal + 3 == sortedCards[3].cardType.ordinal) &&
                sortedCards[0].cardType == CardType.TWO &&
                sortedCards[4].cardType == CardType.ACE

    private fun containsThreeOfAKind(pokerHand: PokerHand): Boolean{
        val groupedCards = pokerHand.hand.groupBy { it.cardType }
        var threeFound = false
        groupedCards.forEach { (cardType, list) ->
            if(list.size == 3)
                threeFound = true
        }
        return threeFound
    }

    private fun containsFullHouse(pokerHand: PokerHand): Boolean{
        return( containsOnePair(pokerHand) && containsThreeOfAKind(pokerHand))
    }

    private fun containsTwoPair(pokerHand: PokerHand): Boolean{
        val groupedCards = pokerHand.hand.groupBy { it.cardType }
        var pairsFound = 0
        groupedCards.forEach { (cardType, list) ->
            if(list.size == 2) {
                pairsFound++
            }
        }
        return (pairsFound == 2)
    }

    private fun containsOnePair(pokerHand: PokerHand): Boolean{
        val groupedCards = pokerHand.hand.groupBy { it.cardType }
        var twoFound = false
        groupedCards.forEach { (cardType, list) ->
            if(list.size == 2)
                twoFound = true
        }
        return twoFound
    }

    private fun containsHighCard(pokerHand: PokerHand): String{
        val highCard = pokerHand.hand.maxOf{ it.cardType }
        return "$highCard High"
    }


}