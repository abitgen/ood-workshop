package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.set.ChoiceSet

class CopyCatBotPlayer(name: String, private val opponent: Player) : Player(name), IsCopyCatBot {

    private fun getOpponentPreviousChoice(currentRoundIndex: Int): ChoiceSet? {
        return if (currentRoundIndex == 0) ChoiceSet.COOPERATE
        else opponent.choices[currentRoundIndex - 1]
    }

    override fun setPlayerChoice(currentRoundIndex: Int) {
        choice = getOpponentPreviousChoice(currentRoundIndex)
    }
}