package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.domain.player.Player
import com.abit.cooperatecheatgame.set.ChoiceEnterType

class NormalGame : IGameMode {
    override fun runGame(rounds: Int, playerList:List<Player>, machine: GameMachine, choiceEnterType: ChoiceEnterType?) {
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