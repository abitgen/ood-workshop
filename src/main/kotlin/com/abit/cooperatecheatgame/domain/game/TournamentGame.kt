package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.domain.player.Player
import com.abit.cooperatecheatgame.set.ChoiceEnterType
import com.abit.cooperatecheatgame.set.PlayerType
import com.abit.cooperatecheatgame.utils.PlayerDelegate

class TournamentGame(private val playerDelegateList:List<PlayerDelegate>?) : NormalGame() {

    override fun runGame(rounds: Int, playerList:List<Player>, machine: GameMachine, choiceEnterType: ChoiceEnterType?) {

        playerList.forEach { simpleBot ->
            playerDelegateList?.forEach { imitateBot ->
                if(simpleBot != imitateBot) {
                    machine.switchPlayer(simpleBot, PlayerType.PLAYER1)
                    machine.switchPlayer(imitateBot.invoke(simpleBot), PlayerType.PLAYER2)
                    super.runGame(rounds, playerList, machine, choiceEnterType)
                }
            }
        }
    }
}