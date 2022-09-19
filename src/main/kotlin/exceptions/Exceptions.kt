package exceptions

object Exceptions {

    object FileExceptions{
        const val FILE_DOES_NOT_EXIST = "File does not exist"
        const val FILE_IS_EMPTY = "File is empty"
    }

    object CardTypeExceptions{
        const val INVALID_CARD_TYPE = "Invalid Card Type"
    }

    object SuitTypeExceptions{
        const val INVALID_SUIT_TYPE = "Invalid Suit Type"
    }

    object PokerHandExceptions{
        const val INVALID_CARD = "Invalid Card"
        const val INVALID_HAND = "Invalid Hand"
    }
}