package constants

import org.testng.Assert
import org.testng.annotations.Test

class RegularExpressionsTest {

    @Test
    fun pokerHand_constant_correct() {

        //assemble
        val expected = "^[2-9,T,J,Q,K,A][H,D,S,C][ ][2-9,T,J,Q,K,A][H,D,S,C][ ][2-9,T,J,Q,K,A][H,D,S,C][ ][2-9,T,J,Q,K,A][H,D,S,C][ ][2-9,T,J,Q,K,A][H,D,S,C]$"

        //act
        //assert
        Assert.assertEquals(RegularExpressions.POKER_HAND, expected)
    }


    @Test
    fun pokerHand_validCombinations_valid(){

        //assemble
        val regex = RegularExpressions.POKER_HAND.toRegex()

        //act
        //assert
        Assert.assertTrue(regex.matches("2H 2D 2S 2C 2C"))
        Assert.assertTrue(regex.matches("3H 3D 3S 3C 3C"))
        Assert.assertTrue(regex.matches("4H 4D 4S 4C 4C"))
        Assert.assertTrue(regex.matches("5H 5D 5S 5C 5C"))
        Assert.assertTrue(regex.matches("6H 6D 6S 6C 6C"))
        Assert.assertTrue(regex.matches("7H 7D 7S 7C 7C"))
        Assert.assertTrue(regex.matches("8H 8D 8S 8C 8C"))
        Assert.assertTrue(regex.matches("9H 9D 9S 9C 9C"))
        Assert.assertTrue(regex.matches("TH TD TS TC TC"))
        Assert.assertTrue(regex.matches("JH JD JS JC JC"))
        Assert.assertTrue(regex.matches("QH QD QS QC QC"))
        Assert.assertTrue(regex.matches("KH KD KS KC KC"))
        Assert.assertTrue(regex.matches("AH AD AS AC AC"))
    }


    @Test
    fun pokerHand_invalidCombinations_invalid(){

        //assemble
        val regex = RegularExpressions.POKER_HAND.toRegex()

        //act
        //assert
        Assert.assertFalse(regex.matches(""), "empty")
        Assert.assertFalse(regex.matches("AH"), "1 card")
        Assert.assertFalse(regex.matches("AH AH"), "2 cards")
        Assert.assertFalse(regex.matches("AH AH AH"), "3 cards")
        Assert.assertFalse(regex.matches("AH AH AH AH"), "4 cards")
        Assert.assertFalse(regex.matches("1H 1H 1H 1H 1H"), "1, not Ace")
        Assert.assertFalse(regex.matches("AH AD AS AC AC " ), "trailing space")
        Assert.assertFalse(regex.matches(" AH AD AS AC AC" ), "leading space")
        Assert.assertFalse(regex.matches("AH AD AS AC AQ" ), "invalid suit")
        Assert.assertFalse(regex.matches("AH AD AS AC WQ" ), "invalid value")
        Assert.assertFalse(regex.matches("AHAD AS AC WQ" ), "missing space 1")
        Assert.assertFalse(regex.matches("AH ADAS AC WQ" ), "missing space 1")
        Assert.assertFalse(regex.matches("AH AD ASAC WQ" ), "missing space 1")
        Assert.assertFalse(regex.matches("AH AD AS ACWQ" ), "missing space 1")
        Assert.assertFalse(regex.matches("AH AD AS , AC"), "special characters")
        Assert.assertFalse(regex.matches("aH AD AS AC AC"), "lowercase value")
        Assert.assertFalse(regex.matches("Ah AD AS AC AC"), "lowercase suit")
        Assert.assertFalse(regex.matches("AH AD AS AC AC AC"), "6 cards")

    }
}