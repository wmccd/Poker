import pokerlibrary.PokerFileProcessor

fun main(args: Array<String>) {

    PokerFileProcessor().process(
        filename = "./src/main/resources/poker_hands.txt",
        success = ::success,
        failure = ::failure
    )
}

fun success(result:String){
    println(result)
}

fun failure(message:String){
    println("FAIL | $message")
}