package enumerations

import exceptions.Exceptions

enum class CardType( val cardValue: Char) {
    TWO( cardValue='2'),
    THREE(cardValue='3'),
    FOUR(cardValue='4'),
    FIVE(cardValue='5'),
    SIX(cardValue='6'),
    SEVEN(cardValue='7'),
    EIGHT(cardValue='8'),
    NINE(cardValue='9'),
    TEN(cardValue='T'),
    JACK(cardValue='J'),
    QUEEN(cardValue='Q'),
    KING(cardValue='K'),
    ACE(cardValue='A');

    companion object{
        fun convert(cardValue: Char): CardType{

            val all = "23456789TAKQJ"

            if(!all.contains(cardValue) ){
                throw Exception(Exceptions.CardTypeExceptions.INVALID_CARD_TYPE)
            }

            return convertValueToType(cardValue)
        }

        private fun convertValueToType(cardValue: Char): CardType{
            return when(cardValue){
                TWO.cardValue -> TWO
                THREE.cardValue -> THREE
                FOUR.cardValue -> FOUR
                FIVE.cardValue -> FIVE
                SIX.cardValue -> SIX
                SEVEN.cardValue -> SEVEN
                EIGHT.cardValue -> EIGHT
                NINE.cardValue -> NINE
                TEN.cardValue -> TEN
                JACK.cardValue -> JACK
                QUEEN.cardValue -> QUEEN
                KING.cardValue -> KING
                else -> ACE
            }
        }
    }
}