package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.set.ChoiceSet

class GrudgerBotPlayer(name: String, private val opponent: Player) : Player(name), IBotChoiceSetter {

    private fun hasOpponentCheatedOnce(currentRoundIndex: Int): ChoiceSet? {
        return if( opponent.choices.dropLast(1).count { it == ChoiceSet.CHEAT } > 0){
            ChoiceSet.CHEAT
        }else{
            ChoiceSet.COOPERATE
        }
    }

    override fun setPlayerChoice(currentRoundIndex: Int) {
        choice = hasOpponentCheatedOnce(currentRoundIndex)
    }
}