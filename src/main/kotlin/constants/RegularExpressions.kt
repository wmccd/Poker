package constants

class RegularExpressions {


    companion object{
        private const val POKER_CARD = "[2-9,T,J,Q,K,A][H,D,S,C]"
        const val POKER_HAND = "^$POKER_CARD[ ]$POKER_CARD[ ]$POKER_CARD[ ]$POKER_CARD[ ]$POKER_CARD$"

    }
}