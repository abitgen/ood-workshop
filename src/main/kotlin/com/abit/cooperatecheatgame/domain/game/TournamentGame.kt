package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.domain.player.Player
import com.abit.cooperatecheatgame.set.ChoiceEnterType
import com.abit.cooperatecheatgame.set.PlayerType
import com.abit.cooperatecheatgame.utils.PlayerDelegate

class TournamentGame(val playerDelegateList:List<PlayerDelegate>) : IGameMode{

    override fun runGame(rounds: Int, playerList:List<Player>, machine: GameMachine, choiceEnterType: ChoiceEnterType?) {

        playerList.forEach { simpleBot ->
            playerDelegateList.forEach { imitateBot ->
                if(simpleBot != imitateBot) {
                    machine.switchPlayer(simpleBot, PlayerType.PLAYER1)
                    machine.switchPlayer(imitateBot.invoke(simpleBot), PlayerType.PLAYER2)
                    duplicateLogic(rounds, machine, choiceEnterType)
                }
            }
        }
    }

    private fun duplicateLogic(rounds: Int, machine: GameMachine, choiceEnterType: ChoiceEnterType?){
        for (i in 0 until rounds) {
            machine.onGameStart()
            machine.setRealPlayerChoices(choiceEnterType)
            machine.setBotPlayerChoices(i)
            machine.startRound(i)
            machine.showRoundInfo()
        }
        machine.onGameOver()
    }

}