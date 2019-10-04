package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.domain.player.Player
import com.abit.cooperatecheatgame.domain.choice.ChoiceEnterType
import com.abit.cooperatecheatgame.domain.player.PlayerType

class TournamentGame : NormalGame() {
    private val playerMatchComplete = hashSetOf<String>()

    override fun runGame(rounds: Int, playerList:List<Player>, machine: GameMachine, choiceEnterType: ChoiceEnterType?) {
        playerList.forEach { botA ->
            playerList.forEach { botB ->
                val matchPlayerPair = listOf(botA.name,botB.name).sorted().joinToString("-")
                if(botA != botB && !playerMatchComplete.contains(matchPlayerPair)) {
                    newTournamentGame(botA, botB, machine, rounds, playerList, choiceEnterType)
                    playerMatchComplete.add(matchPlayerPair)
                }
            }
        }

        println("\n >>>>>>>>>>>>> Tournament Over <<<<<<<<<<<<<<< \n")
        playerList.forEach {
            machine.onGameOver(it)
        }
    }

    private fun newTournamentGame(player1:Player, player2:Player, machine: GameMachine, rounds: Int, playerList: List<Player>, choiceEnterType: ChoiceEnterType?){
        machine.switchPlayer(player1, PlayerType.PLAYER1)
        machine.switchPlayer(player2, PlayerType.PLAYER2)
        super.runGame(rounds, playerList, machine, choiceEnterType)
        machine.resetPlayer(PlayerType.PLAYER1)
        machine.resetPlayer(PlayerType.PLAYER2)
    }
}