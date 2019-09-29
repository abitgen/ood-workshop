package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.set.ChoiceSet

class CopyCatBotPlayer(name: String, private val opponentChoiceList: List<ChoiceSet?>) : Player(name), IBotChoiceSetter {

    private fun getOpponentPreviousChoice(currentRoundIndex: Int): ChoiceSet? {
        return if (currentRoundIndex == 0) ChoiceSet.COOPERATE
        else opponentChoiceList[currentRoundIndex - 1]
    }

    override fun setPlayerChoice(currentRoundIndex: Int) {
        choice = getOpponentPreviousChoice(currentRoundIndex)
    }
}