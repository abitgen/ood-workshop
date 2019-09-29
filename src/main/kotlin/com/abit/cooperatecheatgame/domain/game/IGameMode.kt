package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.domain.player.Player
import com.abit.cooperatecheatgame.set.ChoiceEnterType

interface IGameMode {
    fun runGame(rounds: Int,
                playerList:List<Player>,
                machine: GameMachine,
                choiceEnterType: ChoiceEnterType? = null)
}