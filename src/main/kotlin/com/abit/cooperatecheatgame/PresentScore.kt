package com.abit.cooperatecheatgame

class PresentScore() {
    fun doPrintRound(player:Player, choice: ChoiceProvider){
        println(" Player ${player.name} played "+choice.getPlayerChoice()+" ")
    }

    fun doPrintGameOver(player:Player){
        println(" Player ${player.name} scroe ${player.getPlayerScore()} ")
    }

    fun doPrintSeparator(){
        println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ")
    }
}