package com.abit.cooperatecheatgame

import com.abit.cooperatecheatgame.domain.player.*
import com.abit.cooperatecheatgame.domain.choice.ChoiceEnterType
import com.abit.cooperatecheatgame.domain.player.PlayerType
import com.abit.cooperatecheatgame.Constants.Companion.NO_OF_ROUNDS
import com.abit.cooperatecheatgame.domain.game.GameLogic
import com.abit.cooperatecheatgame.domain.game.GameMachine
import com.abit.cooperatecheatgame.domain.game.GameType
import com.abit.cooperatecheatgame.utils.InitGameMachine
import com.abit.cooperatecheatgame.utils.PresentScore

class Play {
    fun startPlay(
        rounds: Int,
        playerList:List<Player>,
        machine: GameMachine,
        choiceEnterType: ChoiceEnterType? = null,
        gameType: GameType = GameType.NORMAL) {

        gameType.mode.invoke().runGame(rounds, playerList, machine, choiceEnterType)

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
    //testOneRealOneEvilBotPlayers(play)
    //testOneRealOneGoodBotPlayers(play)
    //testEvilCopyCatBotPlayer(play, gameMachine)
    //testOneRealOneCopyCatBotPlayer(play, gameMachine)
    //testOneRealOneGrudgerBotPlayer(play, gameMachine)
    testTournamentRandomRealGame(play, gameMachine)
}

fun testTournamentRandomRealGame(play: Play, gameMachine: InitGameMachine) {

    val simplePlayerList = mutableListOf<Player>()
    for (i in 1..100) {
        val userA: Player = RealPlayer("User $i")
        simplePlayerList.add(userA)
    }

    play.startPlay(NO_OF_ROUNDS, simplePlayerList, gameMachine(simplePlayerList), ChoiceEnterType.RANDOM, GameType.TOURNAMENT)
}

fun testTournamentGame(play: Play, gameMachine: InitGameMachine) {
    val goodBot: Player = GoodBotPlayer("Good")
    val copyCatBot: Player = CopyCatBotPlayer("Copycat")
    val grudgeBot: Player = GrudgerBotPlayer("Grudger")
    val evilBot: Player = EvilBotPlayer("Evil")
    val userA: Player = RealPlayer("User A")
    val userB: Player = RealPlayer("User B")

    val simplePlayerList = listOf(goodBot, evilBot, copyCatBot, grudgeBot, userA, userB)
    //val a: List<IBotChoiceSetter> = listOf(copyCatBot, grudgeBot)
    play.startPlay(NO_OF_ROUNDS, simplePlayerList, gameMachine(simplePlayerList), ChoiceEnterType.RANDOM, GameType.TOURNAMENT)
}

fun <T> asss(list:Array<in IBotChoiceSetter>){

}

fun testTwoRealPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = RealPlayer("SomeName")
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, playerList, gameMachine(playerList), ChoiceEnterType.CLI)
}

fun testOneRealOneGoodBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = GoodBotPlayer("Android")
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, playerList, gameMachine(playerList), ChoiceEnterType.RANDOM)
}

fun testOneRealOneEvilBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = EvilBotPlayer("Apple")
    val playerList = listOf(player1, player2)
    play.startPlay(2, playerList, gameMachine(playerList))
}

fun testTwoBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = GoodBotPlayer("Android")
    val player2: Player = EvilBotPlayer("Apple")
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, playerList, gameMachine(playerList))
}

fun testEvilCopyCatBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = EvilBotPlayer("Android")
    val player2: Player = CopyCatBotPlayer("Apple")
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, playerList, gameMachine(playerList))
}

fun testOneRealOneCopyCatBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("User")
    val player2: Player = CopyCatBotPlayer("Android")
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, playerList, gameMachine(playerList), ChoiceEnterType.CLI)
}

fun testOneRealOneGrudgerBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("User A")
    val player2: Player = GrudgerBotPlayer("Android")
    val playerList = listOf(player1, player2)
    play.startPlay(NO_OF_ROUNDS, playerList, gameMachine(playerList), ChoiceEnterType.RANDOM)
}








