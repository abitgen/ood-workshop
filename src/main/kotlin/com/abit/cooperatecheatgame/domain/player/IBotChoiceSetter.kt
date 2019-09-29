package com.abit.cooperatecheatgame.domain.player

interface IBotChoiceSetter : IsBot {
    fun setPlayerChoice(currentRoundIndex: Int)
}