package com.abit.cooperatecheatgame

import com.abit.cooperatecheatgame.domain.player.*
import com.abit.cooperatecheatgame.set.ChoiceEnterType
import com.abit.cooperatecheatgame.set.PlayerType
import com.abit.cooperatecheatgame.Constants.Companion.NO_OF_ROUNDS
import com.abit.cooperatecheatgame.domain.game.GameLogic
import com.abit.cooperatecheatgame.domain.game.GameMachine
import com.abit.cooperatecheatgame.utils.InitGameMachine
import com.abit.cooperatecheatgame.utils.PresentScore

class Play {
    fun startPlay(
        rounds: Int,
        machine: GameMachine,
        choiceEnterType: ChoiceEnterType? = null) {

        for (i in 0 until rounds) {
            machine.setRealPlayerChoices(choiceEnterType)
            machine.setBotPlayerChoices(i)
            machine.startRound(i)
            machine.showRoundInfo()
        }
        machine.onGameOver()
    }
}

fun main() {
    val play = Play()
    val gameMachine: InitGameMachine = {
        GameMachine(
            hashMapOf(
                PlayerType.PLAYER1 to it[0],
                PlayerType.PLAYER2 to it[1]
            ),
            GameLogic(),
            PresentScore()
        )
    }

    //testTwoRealPlayers(play, gameMachine)
    // testTwoBotPlayers(play)
    /* testOneRealOneEvilBotPlayers(play)
     testOneRealOneGoodBotPlayers(play)*/
    //testEvilCopyCatBotPlayer(play, gameMachine)
    //testOneRealOneCopyCatBotPlayer(play, gameMachine)
    testOneRealOneGrudgerBotPlayer(play, gameMachine)
}



















fun testTwoRealPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = RealPlayer("SomeName")

    val playerList = listOf(player1, player2)

    play.startPlay(NO_OF_ROUNDS, gameMachine(playerList), ChoiceEnterType.CLI)
}




















fun testOneRealOneGoodBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = GoodBotPlayer("Android")

    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, gameMachine(playerList), ChoiceEnterType.RANDOM)
}











fun testOneRealOneEvilBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = EvilBotPlayer("Apple")

    val playerList = listOf(player1, player2)

    play.startPlay(2, gameMachine(playerList))
}













fun testTwoBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player =
        GoodBotPlayer("Android")
    val player2: Player = EvilBotPlayer("Apple")
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, gameMachine(playerList))
}













fun testEvilCopyCatBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player =
        EvilBotPlayer("Android")
    val player2: Player =
        CopyCatBotPlayer("Apple", player1)
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, gameMachine(playerList))
}














fun testOneRealOneCopyCatBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player =
        RealPlayer("User")
    val player2: Player =
        CopyCatBotPlayer("Android", player1)
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, gameMachine(playerList), ChoiceEnterType.CLI)

}


















fun testOneRealOneGrudgerBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player =
        RealPlayer("User A")
    val player2: Player =
        GrudgerBotPlayer("Android", player1)
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, gameMachine(playerList), ChoiceEnterType.RANDOM)

}
