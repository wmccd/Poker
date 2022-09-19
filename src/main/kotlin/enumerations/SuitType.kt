package enumerations

import exceptions.Exceptions

enum class SuitType(val suitValue: Char) {
    HEART(suitValue='H'),
    SPADE(suitValue='S'),
    DIAMOND(suitValue='D'),
    CLUB(suitValue='C');

    companion object{
        fun convert(suitValue: Char): SuitType{

            val all = "HDSC"

            if(!all.contains(suitValue) ){
                throw Exception(Exceptions.SuitType.INVALID_SUIT_TYPE)
            }

            return convertValueToType(suitValue)
        }

        private fun convertValueToType(suitValue: Char): SuitType{
            return when(suitValue){
                HEART.suitValue -> HEART
                CLUB.suitValue -> CLUB
                DIAMOND.suitValue -> DIAMOND
                else -> SPADE
            }
        }
    }
}