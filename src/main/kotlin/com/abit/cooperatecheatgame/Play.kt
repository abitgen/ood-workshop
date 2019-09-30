package com.abit.cooperatecheatgame

import com.abit.cooperatecheatgame.domain.player.*
import com.abit.cooperatecheatgame.set.ChoiceEnterType
import com.abit.cooperatecheatgame.set.PlayerType
import com.abit.cooperatecheatgame.Constants.Companion.NO_OF_ROUNDS
import com.abit.cooperatecheatgame.domain.game.GameLogic
import com.abit.cooperatecheatgame.domain.game.GameMachine
import com.abit.cooperatecheatgame.domain.game.GameType
import com.abit.cooperatecheatgame.domain.game.IGameMode
import com.abit.cooperatecheatgame.utils.InitGameMachine
import com.abit.cooperatecheatgame.utils.PlayerDelegate
import com.abit.cooperatecheatgame.utils.PresentScore

class Play {
    fun startPlay(
        rounds: Int,
        playerList:List<Player>,
        machine: GameMachine,
        choiceEnterType: ChoiceEnterType? = null,
        gameMode: IGameMode? = null) {

        gameMode?.runGame(rounds, playerList, machine, choiceEnterType)

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
    //testOneRealOneGrudgerBotPlayer(play, gameMachine)
    testTournamentGame(play, gameMachine)
}


fun testTournamentGame(play: Play, gameMachine: (List<Player>) -> GameMachine) {
    val goodBot: Player = GoodBotPlayer("Good")
    val copyCatBot: Player = CopyCatBotPlayer("Copycat")
    val grudgerBot: Player = GrudgerBotPlayer("Grudger")
    val evilBot: Player = EvilBotPlayer("Evil")
    val simplePlayerList = listOf(goodBot, evilBot, copyCatBot, grudgerBot)

    play.startPlay(
        NO_OF_ROUNDS, simplePlayerList, gameMachine(simplePlayerList),
        ChoiceEnterType.RANDOM, GameType.TOURNAMENT.mode())
}

fun testTwoRealPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = RealPlayer("SomeName")
    val playerList = listOf(player1, player2)
    play.startPlay(Constants.NO_OF_ROUNDS, playerList, gameMachine(playerList), ChoiceEnterType.CLI)
}

fun testOneRealOneGoodBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = GoodBotPlayer("Android")
    val playerList = listOf(player1, player2)
    play.startPlay(
        Constants.NO_OF_ROUNDS, playerList, gameMachine(playerList),
        ChoiceEnterType.RANDOM, gameMode = GameType.NORMAL.mode())
}

fun testOneRealOneEvilBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("Kumar")
    val player2: Player = EvilBotPlayer("Apple")
    val playerList = listOf(player1, player2)
    play.startPlay(2, playerList, gameMachine(playerList), gameMode = GameType.NORMAL.mode())
}

fun testTwoBotPlayers(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = GoodBotPlayer("Android")
    val player2: Player = EvilBotPlayer("Apple")
    val playerList = listOf(player1, player2)
    play.startPlay(Constants.NO_OF_ROUNDS, playerList, gameMachine(playerList), gameMode = GameType.NORMAL.mode())
}

fun testEvilCopyCatBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = EvilBotPlayer("Android")
    val player2: Player = CopyCatBotPlayer("Apple")
    val playerList = listOf(player1, player2)
    play.startPlay(Constants.NO_OF_ROUNDS, playerList, gameMachine(playerList), gameMode = GameType.NORMAL.mode())
}

fun testOneRealOneCopyCatBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("User")
    val player2: Player = CopyCatBotPlayer("Android")
    val playerList = listOf(player1, player2)
    play.startPlay(Constants.NO_OF_ROUNDS, playerList, gameMachine(playerList), ChoiceEnterType.CLI, GameType.NORMAL.mode())
}

fun testOneRealOneGrudgerBotPlayer(play: Play, gameMachine: InitGameMachine) {
    val player1: Player = RealPlayer("User A")
    val player2: Player = GrudgerBotPlayer("Android")
    val playerList = listOf(player1, player2)
    play.startPlay(
        NO_OF_ROUNDS, playerList, gameMachine(playerList),
        ChoiceEnterType.CLI, GameType.NORMAL.mode())

}








