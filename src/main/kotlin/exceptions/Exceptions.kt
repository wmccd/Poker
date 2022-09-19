package exceptions

object Exceptions {

    object File{
        const val FILE_DOES_NOT_EXIST = "File does not exist"
        const val FILE_IS_EMPTY = "File is empty"
    }

    object CardType{
        const val INVALID_CARD_TYPE = "Invalid Card Type"
    }

    object SuitType{
        const val INVALID_SUIT_TYPE = "Invalid Suit Type"
    }

    object PokerHand{
        const val INVALID_CARD = "Invalid Card"
        const val INVALID_HAND = "Invalid Hand"
    }
}