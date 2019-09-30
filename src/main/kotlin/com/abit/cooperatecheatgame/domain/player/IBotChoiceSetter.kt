package com.abit.cooperatecheatgame.domain.player

import com.abit.cooperatecheatgame.set.ChoiceSet

interface IBotChoiceSetter : IsBot {
    fun setPlayerChoice(currentRoundIndex: Int, opponentChoiceList: List<ChoiceSet?>)
}