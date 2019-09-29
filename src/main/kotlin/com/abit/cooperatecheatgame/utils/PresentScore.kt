package com.abit.cooperatecheatgame.utils

import com.abit.cooperatecheatgame.domain.player.Player

class PresentScore() {
    fun doPrintRound(player: Player?){
        println(" Player ${player?.name} played "+player?.getPlayerChoice()+" ")
    }

    fun doPrintGameOver(player: Player?){
        println(" Player ${player?.name} score ${player?.getPlayerScore()} ")
    }

    fun doPrintSeparator(){
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ")
    }
}