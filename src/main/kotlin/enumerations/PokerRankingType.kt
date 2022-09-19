package enumerations

enum class PokerRankingType(val rank: Int, val description: String) {
    ROYAL_FLUSH(rank=1, description = "Royal Flush"),
    STRAIGHT_FLUSH(rank=2, description = "Straight Flush"),
    FOUR_OF_A_KIND(rank=3, description = "Four of a Kind"),
    FULL_HOUSE(rank=4, description = "Full House"),
    FLUSH(rank=5, description = "Flush"),
    STRAIGHT(rank=6, description = "Straight"),
    THREE_OF_A_KIND(rank=7, description = "Three of a Kind"),
    TWO_PAIR(rank=8, description = "Two Pair"),
    ONE_PAIR(rank=9, description = "One Pair"),
    HIGH_CARD(rank=10, description = "High Card")
}