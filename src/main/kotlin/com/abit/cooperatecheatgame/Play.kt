package com.abit.cooperatecheatgame

import java.awt.Choice

class Play {
    fun startPlay(rounds:Int, logic: GameLogic, presentScore: PresentScore, playerList:List<Player>, choiceCallback:(()-> Map<PlayerType, ChoiceSet>?)? = null ){
      /*  var playerAScore :Int = 0
        var playerBScore :Int = 0*/
            for(i in 1..rounds) {

                val choiceList: Map<PlayerType, ChoiceSet>? = choiceCallback?.let { it() }

                playerList[0].setPlayerChoice(choiceList?.get(PlayerType.PLAYER1))
                playerList[1].setPlayerChoice(choiceList?.get(PlayerType.PLAYER2))

                val round = Round(Math.random().toLong())
                round.startRound(playerList, logic)
                presentScore.doPrintRound(playerList[0])
                presentScore.doPrintRound(playerList[1])
                presentScore.doPrintSeparator()
                /*println(" Player ${playerList[0].name} played "+playerList[0].getPlayerChoice()+" ")
                println(" Player ${playerList[1].name} played "+playerList[1].getPlayerChoice()+" ")*/
                //println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" )

                /*playerAScore += result.first
                playerBScore += result.second*/
            }
        presentScore.doPrintGameOver(playerList[0])
        presentScore.doPrintGameOver(playerList[1])
        /*println(" Player A points "+playerAScore+" ")
        println(" Player B points "+playerBScore+" ")*/
    }
}



fun testTwoRealPlayers(play:Play){
    val player1 : Player = RealPlayer("Kumar")
    val player2 : Player = RealPlayer("SomeName")

    val playerList = listOf(player1, player2)

    //val choicesList = { listOf(ChoiceSet.values().random(), ChoiceSet.values().random()) }
    val choicesList ={ hashMapOf(PlayerType.PLAYER1 to ChoiceSet.values().random(), PlayerType.PLAYER2 to ChoiceSet.values().random()) }

    play.startPlay(2, GameLogic(), PresentScore(), playerList, choicesList)
}

fun testOneRealOneGoodBotPlayers(play:Play){
    val player1 : Player = RealPlayer("Kumar")
    val player2 : Player = GoodBotPlayer("Android")

    val playerList = listOf(player1, player2)

    val achoice = ChoiceSet.values().random()
    val bchoice = ChoiceSet.values().random()

    val choicesList ={ hashMapOf(PlayerType.PLAYER1 to ChoiceSet.values().random(), PlayerType.PLAYER2 to ChoiceSet.values().random()) }

    play.startPlay(2, GameLogic(), PresentScore(), playerList, choicesList)
}

fun testOneRealOneEvilBotPlayers(play:Play){
    val player1 : Player = RealPlayer("Kumar")
    val player2 : Player = EvilBotPlayer("Apple")

    val playerList = listOf(player1, player2)
    //val choiceProviderList: List<ChoiceProvider> = playerList.filter { it is ChoiceProvider }


    val achoice = ChoiceSet.values().random()
    val bchoice = ChoiceSet.values().random()
    val choicesList ={ hashMapOf(PlayerType.PLAYER1 to ChoiceSet.values().random(), PlayerType.PLAYER2 to ChoiceSet.values().random()) }

    play.startPlay(2, GameLogic(), PresentScore(), playerList, choicesList)
}

fun testTwoBotPlayers(play:Play){
    val player1 : Player = GoodBotPlayer("Android")
    val player2 : Player = EvilBotPlayer("Apple")
    val playerList = listOf(player1, player2)
    play.startPlay(2, GameLogic(), PresentScore(), playerList)
}

fun testGoodCopyCatBotPlayer(play: Play){
    val player1 : Player = GoodBotPlayer("Android")
    val player2 : Player = CopyCatBotPlayer("Apple", player1)
    val playerList = listOf(player1, player2)
    play.startPlay(2, GameLogic(), PresentScore(), playerList)

}


fun main(){
    val play = Play()
    testTwoRealPlayers(play)
   // testTwoBotPlayers(play)
    /* testOneRealOneEvilBotPlayers(play)
     testOneRealOneGoodBotPlayers(play)*/
}