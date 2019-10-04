package com.abit.cooperatecheatgame.domain.game

import com.abit.cooperatecheatgame.domain.player.Player
import com.abit.cooperatecheatgame.domain.player.PlayerType

data class Round(val roundId:Int){
    fun startRound(playerList: Map<PlayerType, Player>, logic: GameLogic): HashMap<PlayerType, Int> {
        val player1 = playerList[PlayerType.PLAYER1]
        val player2 = playerList[PlayerType.PLAYER2]
        val scorePair =  logic.computeLogic(player1?.getPlayerChoice(), player2?.getPlayerChoice())
        return hashMapOf(PlayerType.PLAYER1 to scorePair.first , PlayerType.PLAYER2 to scorePair.second)
    }
}