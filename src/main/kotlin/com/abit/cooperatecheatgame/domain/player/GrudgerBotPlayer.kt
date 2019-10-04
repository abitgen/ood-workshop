package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.domain.choice.ChoiceSet

class GrudgerBotPlayer(name: String) : Player(name), IBotChoiceSetter {

    private fun hasOpponentCheatedOnce(currentRoundIndex: Int, opponentChoiceList: List<ChoiceSet?>): ChoiceSet? {
        return if( opponentChoiceList.dropLast(1).count { it == ChoiceSet.CHEAT } > 0){
            ChoiceSet.CHEAT
        }else{
            ChoiceSet.COOPERATE
        }
    }

    override fun setPlayerChoice(currentRoundIndex: Int, opponentChoiceList: List<ChoiceSet?>) {
        choice = hasOpponentCheatedOnce(currentRoundIndex, opponentChoiceList)
    }
}