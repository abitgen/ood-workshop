package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.set.ChoiceSet

class GrudgerBotPlayer(name: String, private val opponentChoiceList: List<ChoiceSet?>) : Player(name), IBotChoiceSetter {

    private fun hasOpponentCheatedOnce(currentRoundIndex: Int): ChoiceSet? {
        return if( opponentChoiceList.dropLast(1).count { it == ChoiceSet.CHEAT } > 0){
            ChoiceSet.CHEAT
        }else{
            ChoiceSet.COOPERATE
        }
    }

    override fun setPlayerChoice(currentRoundIndex: Int) {
        choice = hasOpponentCheatedOnce(currentRoundIndex)
    }
}