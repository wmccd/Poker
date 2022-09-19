package models

import enumerations.CardType
import enumerations.SuitType

data class PokerCard(val cardType: CardType, val suitType: SuitType)