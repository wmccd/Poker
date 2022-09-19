package pokerlibrary

import repository.file.FileReader

class PokerFileProcessor {

    fun process(filename: String, success:(String)->Unit, failure:(String) -> Unit ){

        var rawPokerHandList: ArrayList<String>
        try{
            rawPokerHandList = readPokerFile(filename = filename)
        }catch(ex: Exception) {
            failure("FILE ISSUE: ${ex.message ?: ""}")
            return
        }

        val pokerHandCreator = PokerHandCreator()
        val pokerHandRanker = PokerHandRanker()
        rawPokerHandList.forEach { rawPokerHand ->
            processPokerHand(
                pokerHandCreator = pokerHandCreator,
                pokerHandRanker = pokerHandRanker,
                rawPokerHand = rawPokerHand,
                success = success,
                failure = failure
            )
        }

    }

    private fun processPokerHand(
        pokerHandCreator: PokerHandCreator,
        pokerHandRanker: PokerHandRanker,
        rawPokerHand: String,
        success: (String) -> Unit,
        failure: (String) -> Unit
    ) {
        try {
            val pokerHand = pokerHandCreator.tryGenerate(rawPokerHand)
            val rank = pokerHandRanker.rank(pokerHand)
            success("$rawPokerHand => $rank")
        } catch (ex: Exception) {
            failure("HAND ISSUE:<${rawPokerHand}> ${ex.message ?: ""}")
        }
    }

    private fun readPokerFile(filename: String): ArrayList<String>{
        val fileReader = FileReader()
        return fileReader.read(filename)
    }


}