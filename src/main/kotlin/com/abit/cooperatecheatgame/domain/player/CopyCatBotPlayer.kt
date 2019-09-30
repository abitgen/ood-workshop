package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.set.ChoiceSet

class CopyCatBotPlayer(name: String) : Player(name), IBotChoiceSetter {

    private fun getOpponentPreviousChoice(currentRoundIndex: Int, opponentChoiceList: List<ChoiceSet?>): ChoiceSet? {
        return if (currentRoundIndex == 0) ChoiceSet.COOPERATE
        else opponentChoiceList[currentRoundIndex - 1]
    }

    override fun setPlayerChoice(currentRoundIndex: Int, opponentChoiceList: List<ChoiceSet?>) {
        choice = getOpponentPreviousChoice(currentRoundIndex, opponentChoiceList)
    }
}