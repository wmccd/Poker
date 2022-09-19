package pokerlibrary

import constants.PokerConstants
import enumerations.CardType
import enumerations.SuitType
import exceptions.Exceptions
import models.PokerCard
import models.PokerHand

class PokerHandCreator {

    companion object{
        private const val SPLITTER = " "
        private const val RAW_STRING_LENGTH = 14
    }

    fun tryGenerate(rawStringHand: String): PokerHand{
        return convertToPokerHand(rawStringHand)
    }

    private fun convertToPokerHand(rawStringHand: String): PokerHand{

        if(rawStringHand.length != RAW_STRING_LENGTH){
            throw Exception("${Exceptions.PokerHand.INVALID_HAND}<$rawStringHand>")
        }

        val pokerCards = hashSetOf<PokerCard>()
        val list = rawStringHand.split(SPLITTER)
        list.forEach {
            pokerCards.add(
                 convertToPokerCard(rawStringCard = it)
            )
        }

        if(pokerCards.size < PokerConstants.PokerHand.CARD_IN_A_HAND){
            throw Exception("${Exceptions.PokerHand.INVALID_HAND}<$rawStringHand>")
        }

        return PokerHand(pokerCards)
    }

    private fun convertToPokerCard(rawStringCard: String): PokerCard{

        try {
            val cardType = CardType.convert(rawStringCard[0])
            val suitType = SuitType.convert(rawStringCard[1])

            return PokerCard(
                cardType = cardType,
                suitType = suitType
            )
        }catch(ex: Exception){
            throw Exception("${Exceptions.PokerHand.INVALID_CARD}<$rawStringCard>")
        }
    }


}