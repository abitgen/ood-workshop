package com.abit.cooperatecheatgame

import java.lang.IllegalArgumentException

data class Round(val roundId:Long){
    fun startRound(playerList: List<Player>, logic: GameLogic){


        val realPlayerList = playerList.filter { it is RealPlayer }
        val botPlayerList = playerList.filter { it is GoodBotPlayer }
        val player1Choice: ChoiceSet? = playerList[0].getPlayerChoice()
        val player2Choice: ChoiceSet? = playerList[1].getPlayerChoice()
        val scorePair = logic.computeLogic(player1Choice, player2Choice)

        if(realPlayerList.size == 2){
            if(player1Choice == null || player2Choice == null){
                throw IllegalArgumentException("Two Real Players - so choice2 cannot be null")
            }else {
                playerList[0].updateScore(scorePair.first)
                playerList[1].updateScore(scorePair.second)
            }
        }else if (realPlayerList.size == 1){
            realPlayerList[0].updateScore(scorePair.first)
            botPlayerList[0].updateScore(scorePair.second)
        }else if(botPlayerList.size == 2){
            botPlayerList[0].updateScore(scorePair.first)
            botPlayerList[1].updateScore(scorePair.second)
        }
    }
}