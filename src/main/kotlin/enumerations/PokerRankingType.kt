package enumerations

enum class PokerRankingType( val description: String) {
    STRAIGHT_ROYAL_FLUSH(description = "Straight Royal Flush"),
    STRAIGHT_FLUSH(description = "Straight Flush"),
    FOUR_OF_A_KIND(description = "Four of a Kind"),
    FULL_HOUSE(description = "Full House"),
    FLUSH(description = "Flush"),
    STRAIGHT(description = "Straight"),
    THREE_OF_A_KIND(description = "Three of a Kind"),
    TWO_PAIR(description = "Two Pair"),
    ONE_PAIR(description = "One Pair"),
    HIGH_CARD(description = "High Card")
}