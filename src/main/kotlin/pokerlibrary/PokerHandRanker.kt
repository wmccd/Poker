package pokerlibrary

import com.google.common.annotations.VisibleForTesting
import enumerations.PokerRankingType
import models.PokerHand

class PokerHandRanker {

    fun rank(pokerHand: PokerHand): String {

        if(checkForFourOfAKind(pokerHand)){
            return PokerRankingType.FOUR_OF_A_KIND.description
        }



        return checkForHighCard(pokerHand = pokerHand)
    }


    private fun checkForFourOfAKind(pokerHand: PokerHand): Boolean{
        val highCards = pokerHand.hand.groupBy { it.cardType }
        var fourFound = false
        highCards.forEach { (cardType, list) ->
            if(list.size == 4)
                fourFound = true
        }

        return fourFound
    }

    private fun checkForHighCard(pokerHand: PokerHand): String{
        val highCard = pokerHand.hand.maxOf{ it.cardType }
        return "$highCard High"
    }


}